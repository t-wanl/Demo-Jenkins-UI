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
public abstract class UISampleDescriptor extends Descriptor<UISample>  implements Action, Describable<UISample> {
    @Override
    public String getDisplayName() {
        return clazz.getSimpleName();
    }

    @Override
    public Descriptor<UISample> getDescriptor() {
        return Jenkins.getInstance().getDescriptor(getClass());
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
    public static ExtensionList<UISampleDescriptor> all() {

//        DescriptorExtensionList<UISample,UISampleDescriptor> desList = Jenkins.getInstance().<UISample,UISampleDescriptor>getDescriptorList(UISample.class);
//        ExtensionList<UISample> list = new ExtensionList<UISample>();
//        for (UISampleDescriptor a : desList) {
//            Type type = a.getClass().getGenericSuperclass();
//            ParameterizedType p=(ParameterizedType)type;
//            Class c=(Class) p.getActualTypeArguments()[0];
//            list.add(c);
//        }
//        return list;
//        return Jenkins.getInstance().<UISample, Descriptor<UISample> >getDescriptorList(UISample.class);
        return Jenkins.getInstance().getExtensionList(UISampleDescriptor.class);
    }
}
