/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.resources.models;

import org.joda.time.DateTime;
import java.util.List;

/**
 * Deployment properties with additional details.
 */
public class DeploymentPropertiesExtended {
    /**
     * Gets or sets the state of the provisioning.
     */
    private String provisioningState;

    /**
     * Gets or sets the correlation ID of the deployment.
     */
    private String correlationId;

    /**
     * Gets or sets the timestamp of the template deployment.
     */
    private DateTime timestamp;

    /**
     * Gets or sets key/value pairs that represent deploymentoutput.
     */
    private Object outputs;

    /**
     * Gets the list of resource providers needed for the deployment.
     */
    private List<Provider> providers;

    /**
     * Gets the list of deployment dependencies.
     */
    private List<Dependency> dependencies;

    /**
     * Gets or sets the template content. Use only one of Template or
     * TemplateLink.
     */
    private Object template;

    /**
     * Gets or sets the URI referencing the template. Use only one of Template
     * or TemplateLink.
     */
    private TemplateLink templateLink;

    /**
     * Deployment parameters. Use only one of Parameters or ParametersLink.
     */
    private Object parameters;

    /**
     * Gets or sets the URI referencing the parameters. Use only one of
     * Parameters or ParametersLink.
     */
    private ParametersLink parametersLink;

    /**
     * Gets or sets the deployment mode. Possible values include:
     * 'Incremental', 'Complete'.
     */
    private DeploymentMode mode;

    /**
     * Get the provisioningState value.
     *
     * @return the provisioningState value
     */
    public String getProvisioningState() {
        return this.provisioningState;
    }

    /**
     * Set the provisioningState value.
     *
     * @param provisioningState the provisioningState value to set
     */
    public void setProvisioningState(String provisioningState) {
        this.provisioningState = provisioningState;
    }

    /**
     * Get the correlationId value.
     *
     * @return the correlationId value
     */
    public String getCorrelationId() {
        return this.correlationId;
    }

    /**
     * Set the correlationId value.
     *
     * @param correlationId the correlationId value to set
     */
    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    /**
     * Get the timestamp value.
     *
     * @return the timestamp value
     */
    public DateTime getTimestamp() {
        return this.timestamp;
    }

    /**
     * Set the timestamp value.
     *
     * @param timestamp the timestamp value to set
     */
    public void setTimestamp(DateTime timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Get the outputs value.
     *
     * @return the outputs value
     */
    public Object getOutputs() {
        return this.outputs;
    }

    /**
     * Set the outputs value.
     *
     * @param outputs the outputs value to set
     */
    public void setOutputs(Object outputs) {
        this.outputs = outputs;
    }

    /**
     * Get the providers value.
     *
     * @return the providers value
     */
    public List<Provider> getProviders() {
        return this.providers;
    }

    /**
     * Set the providers value.
     *
     * @param providers the providers value to set
     */
    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }

    /**
     * Get the dependencies value.
     *
     * @return the dependencies value
     */
    public List<Dependency> getDependencies() {
        return this.dependencies;
    }

    /**
     * Set the dependencies value.
     *
     * @param dependencies the dependencies value to set
     */
    public void setDependencies(List<Dependency> dependencies) {
        this.dependencies = dependencies;
    }

    /**
     * Get the template value.
     *
     * @return the template value
     */
    public Object getTemplate() {
        return this.template;
    }

    /**
     * Set the template value.
     *
     * @param template the template value to set
     */
    public void setTemplate(Object template) {
        this.template = template;
    }

    /**
     * Get the templateLink value.
     *
     * @return the templateLink value
     */
    public TemplateLink getTemplateLink() {
        return this.templateLink;
    }

    /**
     * Set the templateLink value.
     *
     * @param templateLink the templateLink value to set
     */
    public void setTemplateLink(TemplateLink templateLink) {
        this.templateLink = templateLink;
    }

    /**
     * Get the parameters value.
     *
     * @return the parameters value
     */
    public Object getParameters() {
        return this.parameters;
    }

    /**
     * Set the parameters value.
     *
     * @param parameters the parameters value to set
     */
    public void setParameters(Object parameters) {
        this.parameters = parameters;
    }

    /**
     * Get the parametersLink value.
     *
     * @return the parametersLink value
     */
    public ParametersLink getParametersLink() {
        return this.parametersLink;
    }

    /**
     * Set the parametersLink value.
     *
     * @param parametersLink the parametersLink value to set
     */
    public void setParametersLink(ParametersLink parametersLink) {
        this.parametersLink = parametersLink;
    }

    /**
     * Get the mode value.
     *
     * @return the mode value
     */
    public DeploymentMode getMode() {
        return this.mode;
    }

    /**
     * Set the mode value.
     *
     * @param mode the mode value to set
     */
    public void setMode(DeploymentMode mode) {
        this.mode = mode;
    }

}