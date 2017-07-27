package jenkins.plugins.ui_samples;

import hudson.DescriptorExtensionList;
import hudson.Extension;
import hudson.ExtensionList;
import hudson.model.RootAction;
import hudson.model.Descriptor;
import jenkins.model.ModelObjectWithContextMenu;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

import java.util.List;

/**
 * Entry point to all the UI samples.
 * 
 * @author Kohsuke Kawaguchi
 */
@Extension
public class Root implements RootAction, ModelObjectWithContextMenu {
    public String getIconFileName() {
        return "gear.png";
    }

    public String getDisplayName() {
        return "UI Samples";
    }

    public String getUrlName() {
        return "ui-samples";
    }

    public UISample getDynamic(String name) {
        for (UISample ui : getAll()) {
            if (ui.getUrlName().equals(name))
                return ui;
        }
        return null;
    }

    public List<UISample> getAll() {
        return UISample.all();
    }

    public List<UISample> getAllSamples() {
        return UISample.getAllSamples();
    }

    public ContextMenu doContextMenu(StaplerRequest request, StaplerResponse response) throws Exception {
        return new ContextMenu().addAll(getAll());
    }
}
