package jenkins.plugins.ui_samples;

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
public class DropdownList extends UISample {

    public static final String DEFAULT_SELECTED = "apple";

    @Override
    public String getDescription() {
        return "Show different form elements based on choice in a &lt;select> control";
    }

    private String dropdownListSelected;
    private String dropdownListSelectedAaa;
    private String preSelect;

    public String getDropdownListSelected() {
        return dropdownListSelected;
    }

    public String getDropdownListSelectedAaa() {
        return dropdownListSelectedAaa;
    }

    public String getPreSelect() {
        return preSelect;
    }

    public DropdownList() {
        this(DEFAULT_SELECTED, DEFAULT_SELECTED, DEFAULT_SELECTED);
    }
    @DataBoundConstructor public DropdownList(
            final String dropdownListSelected,
            final String dropdownListSelectedAaa,
            final String preSelect
    ) {
        super();
        this.dropdownListSelected = dropdownListSelected;
        this.preSelect = preSelect;
    }

    public Boolean isType(final String type) {
        if (this.dropdownListSelected == null && type.equals("apple")) {
            return true;
        }
        return type != null && type.equalsIgnoreCase(this.dropdownListSelected);
    }

    @Extension
    public static final class DescriptorImpl extends UISampleDescriptor {

        @Override
        public String getDisplayName() {
            return "DropdownList";
        }

        public ListBoxModel doFillPreSelectItems() throws IOException, ServletException  {
            ListBoxModel model = new ListBoxModel();
            model.add("Apple", "apple");
            model.add("Banana", "banana");
            return model;
        }

        public FormValidation doVerify(
                @QueryParameter String dropdownListSelected
                ) {
            System.out.println(dropdownListSelected);
            String feedback = "You select " + dropdownListSelected;
            return FormValidation.ok(feedback);
        }

        public String doFillDropdownListSelectedAaaItems(
                @QueryParameter String preSelect
        ) throws IOException, ServletException {
            if (preSelect.equalsIgnoreCase("apple")) {
                return "apple";
            }
            return "banana";
        }
    }


}
