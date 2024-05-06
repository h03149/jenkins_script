def call(upstreamJobs) {
    def allUpstreamSuccess = upstreamJobs.every { jobName ->
        def job = Jenkins.instance.getItemByFullName(jobName)
        def lastBuild = job.getLastBuild()
        return lastBuild && lastBuild.result == 'SUCCESS'
    }
    return allUpstreamSuccess
}