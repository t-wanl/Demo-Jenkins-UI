package jenkins.plugins.ui_samples;

import hudson.DescriptorExtensionList;
import hudson.Extension;
import hudson.ExtensionPoint;
import hudson.model.Describable;
import hudson.model.Descriptor;
import jenkins.model.Jenkins;
import hudson.util.XStream2;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

/**
 * @author Alan.Harder@oracle.com
 */

@Extension
public class DropdownList extends UISample {

    @Override
    public String getDescription() {
        return "Show different form elements based on choice in a &lt;select> control";
    }

    private String dropdownListSelected;

    public String getDropdownListSelected() {
        return dropdownListSelected;
    }

//    private final boolean tasty;
    @DataBoundConstructor public DropdownList(final String dropdownListSelected) {
        this.dropdownListSelected = dropdownListSelected;
    }
//    public boolean isTasty() {return tasty;}

    @Extension
    public static class DropDownListDes extends UISampleDescriptor {

        @Override
        public String getDisplayName() {
            return "DropdownListDes";
        }
    }


}
