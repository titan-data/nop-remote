package io.titandata.remote.nop.server

import io.kotlintest.shouldBe
import io.kotlintest.shouldNotBe
import io.kotlintest.specs.StringSpec

class NopRemoteServerTest : StringSpec() {
    private val client = NopRemoteServer()

    init {
        "get provider returns nop" {
            client.getProvider() shouldBe "nop"
        }

        "get commit returns an empty commit" {
            val commit = client.getCommit(emptyMap(), emptyMap(), "id")
            commit shouldNotBe null
            commit!!.size shouldBe 0
        }

        "list commits returns an empty list" {
            val commits = client.listCommits(emptyMap(), emptyMap(), emptyList())
            commits.size shouldBe 0
        }
    }
}
