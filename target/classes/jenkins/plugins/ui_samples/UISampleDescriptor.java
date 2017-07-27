package jenkins.plugins.ui_samples;

import hudson.ExtensionList;
import hudson.ExtensionPoint;
import hudson.model.Action;
import hudson.model.Hudson;
import hudson.model.Descriptor;
import hudson.model.Describable;
import jenkins.model.Jenkins;
import hudson.DescriptorExtensionList;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author Kohsuke Kawaguchi
 */
public abstract class UISampleDescriptor extends Descriptor<UISample> {
    @Override
    public String getDisplayName() {
        return clazz.getSimpleName();
    }

    public String getIconFileName() {
        return "gear.png";
    }

    public String getUrlName() {
        return getClass().getSimpleName();
    }

    protected UISampleDescriptor(Class<? extends UISample> clazz) {
        super(clazz);
    }

    protected UISampleDescriptor() {
    }

    /**
     * Returns all the registered {@link UISample}s.
     */
}
