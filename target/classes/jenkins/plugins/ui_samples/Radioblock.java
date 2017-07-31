package jenkins.plugins.ui_samples;

/**
 * Created by albertxavier on 2017/7/27.
 */

import hudson.Extension;
import hudson.slaves.Cloud;
import hudson.util.FormValidation;
import hudson.util.ListBoxModel;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;

import javax.servlet.ServletException;
import java.io.IOException;

import hudson.DescriptorExtensionList;
import hudson.Extension;
import hudson.ExtensionPoint;
import hudson.RelativePath;
import hudson.model.Describable;
import hudson.model.Descriptor;
import hudson.util.FormValidation;
import hudson.util.ListBoxModel;
import jenkins.model.Jenkins;
import hudson.util.XStream2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

/**
 * @author Alan.Harder@oracle.com
 */

@Extension
public class Radioblock extends UISample {

    private List<Template> templates;

    @Override
    public String getDescription() {
        return "Show nested Radioblocks";
    }



    public Radioblock() {

    }

    @DataBoundConstructor
    public Radioblock(
        final List<Template> templates
    ) {
        super();
        setTemplates(templates == null
                ? Collections.<Template>emptyList()
                : templates);
    }


    private void ensureTemplateList() {
        if (templates == null) {
            templates = new ArrayList<Template>();
        }
    }

    public final void setTemplates(List<Template> newTemplates) {
        synchronized (this) {
            ensureTemplateList();
            templates.clear();
            for (Template newTemplate : newTemplates) {
                templates.add(newTemplate);
//                newTemplate.setAzureCloud(this);
            }
        }
    }

    public List<Template> getTemplates() {
        synchronized (this) {
            ensureTemplateList();
            List<Template> listCopy = new ArrayList<Template>(templates);
            return Collections.unmodifiableList(listCopy);
        }
    }

    public final void addTemplates(Template newTemplate) {
        // Obtain lock while we copy the list.
        synchronized (this) {
            ensureTemplateList();
            templates.add(newTemplate);
//            newTemplate.setAzureCloud(this);
        }
    }

    public final void clearTemplates() {
        // Obtain lock while we copy the list.
        synchronized (this) {
            ensureTemplateList();
            templates.clear();
        }
    }

    @Extension
    public static final class DescriptorImpl extends UISampleDescriptor {

        @Override
        public String getDisplayName() {
            return "Radioblock";
        }


    }


}
