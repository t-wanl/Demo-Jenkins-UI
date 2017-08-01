package jenkins.plugins.ui_samples;

import hudson.model.Descriptor;

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
