package jenkins.plugins.ui_samples;

import hudson.Extension;

/**
 * Created by albertxavier on 2017/7/31.
 */

@Extension
public class BooleanRadio extends UISample {


    @Override
    public String getDescription() {
        return "Show booleanRadio";
    }

    @Extension
    public static final class DescriptorImpl extends UISampleDescriptor {
        @Override
        public String getDisplayName() {
            return "BooleanRadio";
        }

    }

}
