/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator 0.15.0.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.management.resources.models;

import java.util.List;

/**
 * List of resource provider operations.
 */
public class ResourceProviderOperationDetailListResult {
    /**
     * Gets or sets the list of resource provider operations.
     */
    private List<ResourceProviderOperationDefinition> value;

    /**
     * Get the value value.
     *
     * @return the value value
     */
    public List<ResourceProviderOperationDefinition> getValue() {
        return this.value;
    }

    /**
     * Set the value value.
     *
     * @param value the value value to set
     */
    public void setValue(List<ResourceProviderOperationDefinition> value) {
        this.value = value;
    }

}