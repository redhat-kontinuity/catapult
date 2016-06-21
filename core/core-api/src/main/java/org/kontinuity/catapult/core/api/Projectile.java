package org.kontinuity.catapult.core.api;

/**
 * Value object defining the inputs to {@link Catapult#fling(Projectile)};
 * immutable and pre-checked for valid state during creation.
 *
 * @author <a href="mailto:alr@redhat.com">Andrew Lee Rubinger</a>
 */
public class Projectile {

    private final String sourceGitHubRepo;

    private final String gitHubAccessToken;

   /** the name of OpenShift project to create. */
   private String openShiftProjectName;

    /** the path to the file in the repo that contains the pipeline template. */
    private String pipelineTemplatePath;

   private final String gitRef;

    /**
     * Package-level access; to be invoked by {@link ProjectileBuilder}
     * and all precondition checks are its responsibility
     */
    Projectile(final ProjectileBuilder builder){
        this.sourceGitHubRepo = builder.getSourceGitHubRepo();
        this.gitHubAccessToken = builder.getGitHubAccessToken();
       this.openShiftProjectName = builder.getOpenShiftProjectName();
        this.pipelineTemplatePath = builder.getPipelineTemplatePath();
       this.gitRef = builder.getGitRef();
    }

    /**
     * @return the GitHub access token we have obtained from the user as part of
     * the OAuth process
     */
    public String getGitHubAccessToken() {
        return this.gitHubAccessToken;
    }

    /**
     * @return source GitHub repository name in form "owner/repoName".
     */
    public String getSourceGitHubRepo() {
        return this.sourceGitHubRepo;
    }

   /**
    * @return The name to use in creating the new OpenShift project
    */
   public String getOpenShiftProjectName() { return openShiftProjectName;  }

   /**
    * @return The path to the pipeline template file in the repo
    */
   public String getPipelineTemplatePath() { return pipelineTemplatePath; }

   /**
    * @return The Git reference to use
    */
   public String getGitRef() { return gitRef; }
}
