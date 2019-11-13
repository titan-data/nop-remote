package io.titandata.remote.nop.server

import io.titandata.remote.RemoteServer

class NopRemoteServer : RemoteServer {
    override fun getProvider(): String {
        return "nop"
    }

    /**
     * The nop provider always returns success for any commit, and returns an empty set of properties.
     */
    override fun getCommit(remote: Map<String, Any>, parameters: Map<String, Any>, commitId: String): Map<String, Any>? {
        return emptyMap()
    }

    /**
     * The nop provider always returns an empty list of commits.
     */
    override fun listCommits(remote: Map<String, Any>, parameters: Map<String, Any>, tags: List<Pair<String, String?>>): List<Pair<String, Map<String, Any>>> {
        return emptyList()
    }
}
