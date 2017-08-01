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
 * This class defines the sample of dynamic databinding version of &lt;radioBlock&gt;
 *
 * @author t-wanl@microsoft.com
 */

@Extension
public class Radioblock extends UISample {

    @Override
    public String getDescription() {
        return "Show nested Radioblocks";
    }

    @DataBoundConstructor
    public Radioblock() {
    }

    @Extension
    public static final class DescriptorImpl extends UISampleDescriptor {
        @Override
        public String getDisplayName() {
            return "Radioblock - Dynamic Databinding Version";
        }
    }


}
