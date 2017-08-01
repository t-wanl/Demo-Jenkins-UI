package jenkins.plugins.ui_samples;

/**
 * Created by albertxavier on 2017/7/27.
 */

import hudson.Extension;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * This class defines the sample of Jenkins version of &lt;radioBlock&gt;
 *
 * @author t-wanl@microsoft.com
 */

@Extension
public class RadioblockJenkins extends UISample {

    @Override
    public String getDescription() {
        return "Show nested Radioblocks";
    }



    @DataBoundConstructor
    public RadioblockJenkins() {
        super();
    }

    @Extension
    public static final class DescriptorImpl extends UISampleDescriptor {

        @Override
        public String getDisplayName() {
            return "Radioblock - Jenkins Version";
        }


    }


}
