package de.lemona.android.guice.system;

import android.app.job.JobScheduler;
import android.content.Context;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class JobSchedulerProvider extends AbstractServiceProvider<JobScheduler> {

    @Inject
    public JobSchedulerProvider(Context context) {
        super(Context.JOB_SCHEDULER_SERVICE, JobScheduler.class, context);
    }

}
