package org.jenkinsci.plugins.buildgraphview;

import hudson.model.Run;

import java.text.DateFormat;

/**
 * A wrapper on a Run that maitains additional layout information, used during graphical rendering.
 * @author <a href="mailto:nicolas.deloof@gmail.com">Nicolas De Loof</a>
 */
public class BuildExecution {

    private transient Run build;

    // A unique number that identifies when in the FlowRun this job was started
    private int buildIndex;

    private int displayColumn;

    private int displayRow;

    public BuildExecution(Run build) {
        this.build = build;
    }

    public String getId() {
        return "build-" + buildIndex;
    }

    public String getBuildUrl() {
        return this.build != null ? this.build.getAbsoluteUrl() : null;
    }

    public String getStartTime() {
        String formattedStartTime = "";
        if (build.getTime() != null) {
            formattedStartTime = DateFormat.getDateTimeInstance(
                    DateFormat.SHORT,
                    DateFormat.SHORT)
                    .format(build.getTime());
        }
        return formattedStartTime;
    }

    public Run<?,?> getBuild() {
        return build;
    }

    public int getBuildIndex() {
        return buildIndex;
    }

    public int getDisplayColumn() {
        return displayColumn;
    }

    public int getDisplayRow() {
        return displayRow;
    }

    public void setBuildIndex(int buildIndex) {
        this.buildIndex = buildIndex;
    }

    public void setDisplayColumn(int displayColumn) {
        this.displayColumn = displayColumn;
    }

    public void setDisplayRow(int displayRow) {
        this.displayRow = displayRow;
    }

    public String toString() {
        return (build != null ? " #" + build.number : "");
    }

}
