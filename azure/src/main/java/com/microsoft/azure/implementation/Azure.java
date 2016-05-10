/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.implementation;

import com.microsoft.azure.management.compute.AvailabilitySets;
import com.microsoft.azure.management.compute.VirtualMachines;
import com.microsoft.azure.management.compute.implementation.ComputeManager;
import com.microsoft.azure.management.resources.Deployments;
import com.microsoft.azure.management.resources.GenericResources;
import com.microsoft.azure.management.resources.Subscriptions;
import com.microsoft.azure.management.resources.Tenants;
import com.microsoft.azure.management.resources.fluentcore.arm.AzureConfigurable;
import com.microsoft.azure.management.resources.fluentcore.arm.implementation.AzureConfigurableImpl;
import com.microsoft.azure.management.resources.fluentcore.collection.*;
import com.microsoft.azure.management.resources.implementation.ResourceManager;
import com.microsoft.azure.management.resources.implementation.api.ResourceManagementClientImpl;
import com.microsoft.azure.management.storage.StorageAccounts;
import com.microsoft.azure.management.storage.Usages;
import com.microsoft.azure.management.storage.implementation.StorageManager;
import com.microsoft.rest.RestClient;
import com.microsoft.rest.credentials.ServiceClientCredentials;

public final class Azure {
    private final ResourceGroups resourceGroups;
    private final ResourceManager resourceManager;
    private final StorageManager storageManager;
    private final ComputeManager computeManager;

    public static Authenticated authenticate(ServiceClientCredentials credentials) {
        return new AuthenticatedImpl(new RestClient
                .Builder("https://management.azure.com")
                .withCredentials(credentials)
                .build());
    }

    public static Authenticated authenticate(RestClient restClient) {
        return new AuthenticatedImpl(restClient);
    }

    public static Configurable configure() {
        return new ConfigurableImpl();
    }

    public interface Configurable extends AzureConfigurable<Configurable> {
        Authenticated authenticate(ServiceClientCredentials credentials);
    }

    private static final class ConfigurableImpl extends AzureConfigurableImpl<Configurable> implements Configurable {
        @Override
        public Authenticated authenticate(ServiceClientCredentials credentials) {
            return Azure.authenticate(buildRestClient(credentials));
        }
    }

    public interface Authenticated {
        Subscriptions subscriptions();
        Tenants tenants();
        Azure withSubscription(String subscriptionId);
    }

    private static final class AuthenticatedImpl implements Authenticated {
        private RestClient restClient;
        private ResourceManager.Authenticated resourceManagerAuthenticated;

        private AuthenticatedImpl(RestClient restClient) {
            resourceManagerAuthenticated = ResourceManager.authenticate(restClient);
        }

        @Override
        public Subscriptions subscriptions() {
            return resourceManagerAuthenticated.subscriptions();
        }

        @Override
        public Tenants tenants() {
            return resourceManagerAuthenticated.tenants();
        }

        @Override
        public Azure withSubscription(String subscriptionId) {
            return new Azure(restClient, subscriptionId);
        }
    }

    public interface  ResourceGroups extends SupportsListing<Azure.ResourceGroup>,
            SupportsGetting<Azure.ResourceGroup>,
            SupportsCreating<Azure.ResourceGroup.DefinitionBlank>,
            SupportsDeleting,
            SupportsUpdating<Azure.ResourceGroup.UpdateBlank> {
    }

    public interface ResourceGroup extends com.microsoft.azure.management.resources.ResourceGroup {
        Deployments.InGroup deployments();
        StorageAccounts.InGroup storageAccounts();
        // VirtualMachinesInGroup virtualMachines();
        AvailabilitySets.InGroup availabilitySets();
        // VirtualNetworksInGroup virtualNetworks();
    }

    private Azure(RestClient restClient, String subscriptionId) {
        ResourceManagementClientImpl resourceManagementClient = new ResourceManagementClientImpl(restClient);
        resourceManagementClient.setSubscriptionId(subscriptionId);
        this.resourceGroups = new AzureResourceGroupsImpl(resourceManagementClient);
        this.resourceManager = ResourceManager.authenticate(restClient).withSubscription(subscriptionId);
        this.storageManager = StorageManager.authenticate(restClient, subscriptionId);
        this.computeManager = ComputeManager.authenticate(restClient, subscriptionId);
    }

    public ResourceGroups resourceGroups() {
        return resourceGroups;
    }

    public GenericResources genericResources() {
        return resourceManager.genericResources();
    }

    public StorageAccounts storageAccounts() {
        return storageManager.storageAccounts();
    }

    public Usages storageUsages() {
        return storageManager.usages();
    }

    public AvailabilitySets availabilitySets() {
        return computeManager.availabilitySets();
    }

    public VirtualMachines virtualMachines() {
        return computeManager.virtualMachines();
    }
}