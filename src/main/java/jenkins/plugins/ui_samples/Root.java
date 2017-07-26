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

    public UISampleDescriptor getDynamic(String name) {
        for (UISampleDescriptor ui : getDesAll()) {
            System.out.println("ui   = " +  ui.getUrlName());
            System.out.println("name = " + name);
            if (ui.getUrlName().equals(name))
                return ui;
        }
        return null;
    }

    public List<UISample> getAll() {
        for (UISample a: UISample.all()) {
            System.out.println(a);
        }
        return UISample.all();
    }

    public List<UISampleDescriptor> getDesAll() {
        for (Descriptor<UISample> a: UISampleDescriptor.all()) {
            System.out.println(a);
        }
        return UISampleDescriptor.all();
    }
    
//    public List<UISample> getAllGroovy() {
//      return UISample.getGroovySamples();
//    }

    public List<UISample> getAllOther() {
      return UISample.getOtherSamples();
    }
    
    public ContextMenu doContextMenu(StaplerRequest request, StaplerResponse response) throws Exception {
//        return new ContextMenu().addAll(getAll());
        return new ContextMenu().addAll(getDesAll());
    }
}
