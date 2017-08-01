package jenkins.plugins.ui_samples;

import hudson.Extension;
import hudson.util.FormValidation;
import hudson.util.ListBoxModel;

import java.io.IOException;
import javax.servlet.ServletException;

import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;

/**
 * This class defines the sample of dynamic databinding version of &lt;dropdownList&gt;
 *
 * @author t-wanl@microsoft.com
 */

@Extension
public class DropdownList extends UISample {

    public static final String DEFAULT_SELECTED = "apple";

    private String dropdownListSelectedS1;

    private String dropdownListSelectedS2;

    private String preSelect;

    public String getDropdownListSelectedS1() {
        return dropdownListSelectedS1;
    }

    public String getDropdownListSelectedS2() {
        return dropdownListSelectedS2;
    }

    public String getPreSelect() {
        return preSelect;
    }

    public DropdownList() {
        this(DEFAULT_SELECTED, DEFAULT_SELECTED, DEFAULT_SELECTED);
    }

    @DataBoundConstructor public DropdownList(
            final String dropdownListSelectedS1,
            final String dropdownListSelectedS2,
            final String preSelect) {
        super();
        this.dropdownListSelectedS1 = dropdownListSelectedS1;
        this.dropdownListSelectedS2 = dropdownListSelectedS2;
        this.preSelect = preSelect;
    }

    @Override
    public String getDescription() {
        return "Show different form elements based on choice in a &lt;select> control";
    }

    public Boolean isType(final String type) {
        if (this.dropdownListSelectedS1 == null && type.equals("apple")) {
            return true;
        }
        return type != null && type.equalsIgnoreCase(this.dropdownListSelectedS1);
    }

    @Extension
    public static final class DescriptorImpl extends UISampleDescriptor {

        @Override
        public String getDisplayName() {
            return "DropdownList - Dynamic Databinding Version";
        }

        public ListBoxModel doFillPreSelectItems() throws IOException, ServletException  {
            ListBoxModel model = new ListBoxModel();
            model.add("Apple", "apple");
            model.add("Banana", "banana");
            return model;
        }

        public FormValidation doVerify(@QueryParameter String dropdownListSelectedS1) {
            String feedback = "You select " + (dropdownListSelectedS1 == null? "NULL" : dropdownListSelectedS1.toUpperCase());
            return FormValidation.ok(feedback);
        }

        public String doFillDropdownListSelectedS2Items(@QueryParameter String preSelect
        ) throws IOException, ServletException {
            if (preSelect.equalsIgnoreCase("apple")) {
                return "apple";
            }
            return "banana";
        }
    }


}
