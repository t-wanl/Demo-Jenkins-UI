package jenkins.plugins.ui_samples;

import hudson.model.Describable;
import hudson.model.Descriptor;
import jenkins.model.Jenkins;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * Created by albertxavier on 2017/7/31.
 */
public class Template implements Describable<Template> {

    private String name;

    @SuppressWarnings("unchecked")
    public Descriptor<Template> getDescriptor() {
        return Jenkins.getInstance().getDescriptor(getClass());
    }

    @DataBoundConstructor
    public Template(
            final String name
    ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
