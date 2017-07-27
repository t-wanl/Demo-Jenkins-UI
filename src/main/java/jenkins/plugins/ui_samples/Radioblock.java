package jenkins.plugins.ui_samples;

/**
 * Created by albertxavier on 2017/7/27.
 */

import hudson.Extension;
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

    public static final String DEFAULT_SELECTED = "apple";

    @Override
    public String getDescription() {
        return "Show different form elements based on choice in a &lt;select> control";
    }



    public Radioblock() {
//        this(DEFAULT_SELECTED, DEFAULT_SELECTED, DEFAULT_SELECTED);
    }
    @DataBoundConstructor
    public Radioblock(
            final String dropdownListSelected,
            final String dropdownListSelectedAaa,
            final String preSelect
    ) {
        super();
        this.dropdownListSelected = dropdownListSelected;
        this.preSelect = preSelect;
    }

    @Extension
    public static final class DescriptorImpl extends UISampleDescriptor {

        @Override
        public String getDisplayName() {
            return "Radioblock";
        }


    }


}
