package io.github.yermilov.junit5;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.LoggingListener;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import java.io.PrintWriter;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;
import static org.junit.platform.launcher.TagFilter.excludeTags;

public class N12_LaunchTests {

    public static void main(String[] args) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(
                        selectPackage("io.github.yermilov.junit5")
                )
                .filters(
                        excludeTags("slow")
                )
                .build();

        TestPlan plan = LauncherFactory.create().discover(request);

        Launcher launcher = LauncherFactory.create();

        SummaryGeneratingListener summaryGeneratingListener = new SummaryGeneratingListener();
        LoggingListener loggingListener = new LoggingListener((t, messageSupplier) -> { System.err.println(messageSupplier.get()); });

        launcher.execute(request, new TestExecutionListener[] { summaryGeneratingListener, loggingListener });

        summaryGeneratingListener.getSummary().printTo(new PrintWriter(System.out));
    }
}
