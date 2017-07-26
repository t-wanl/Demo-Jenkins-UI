package jenkins.plugins.ui_samples;

import hudson.DescriptorExtensionList;
import hudson.Extension;
import hudson.ExtensionPoint;
import hudson.model.Describable;
import hudson.model.Descriptor;
import hudson.util.FormValidation;
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
public class DropdownList extends UISample {

    public static final String DEFAULT_SELECTED = "apple";

    @Override
    public String getDescription() {
        return "Show different form elements based on choice in a &lt;select> control";
    }

    private String dropdownListSelected;

    public String getDropdownListSelected() {
        return dropdownListSelected;
    }

    public DropdownList() {
        this(DEFAULT_SELECTED);
    }
    @DataBoundConstructor public DropdownList(final String dropdownListSelected) {
        super();
        this.dropdownListSelected = dropdownListSelected;
//        load();
    }

    public Boolean isType(final String type) {
        if (this.dropdownListSelected == null && type.equals("apple")) {
            return true;
        }
        return type != null && type.equalsIgnoreCase(this.dropdownListSelected);
    }

    @Extension
    public static final class DropDownListDes extends UISampleDescriptor {

        @Override
        public String getDisplayName() {
            return "DropdownList";
        }

        public FormValidation doVerify(
                @QueryParameter String dropdownListSelected
                ) {
            System.out.println(dropdownListSelected);
            return FormValidation.ok(dropdownListSelected);
        }
    }


}
