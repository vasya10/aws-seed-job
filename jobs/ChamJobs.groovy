/**
 * Jenkins Seed Jobs for BNC Apps
 */
repos = ['aws-go-helloworld']

repos.each { r ->
  multibranchPipelineJob(r) {
    description(r)
    branchSources {
      github {
        id(r)
        scanCredentialsId('aws-secret')
        repoOwner('vasya10')
        repository(r)
      }
    }
    orphanedItemStrategy {
      discardOldItems {
        numToKeep(5)
        daysToKeep(5)
      }
    }
  }
}
