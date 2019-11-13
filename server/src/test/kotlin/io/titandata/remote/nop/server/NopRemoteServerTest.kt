package io.titandata.remote.nop.server

import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec
import java.net.URI

class NopRemoteServerTest : StringSpec() {
    private val client = NopRemoteServer()

    init {
        "get provider returns nop" {
            client.getProvider() shouldBe "nop"
        }

        "parsing a nop URI succeeds" {
            val result = client.parseUri(URI("nop"), emptyMap())
            result.size shouldBe 0
        }

        "parsing nop URI authority fails" {
            shouldThrow<IllegalArgumentException> {
                client.parseUri(URI("nop://foo"), emptyMap())
            }
        }

        "converting to nop remote succeeds" {
            val (result, properties) = client.toUri(emptyMap())
            result shouldBe "nop"
            properties.size shouldBe 0
        }

        "getting nop parameters succeeds" {
            val result = client.getParameters(emptyMap())
            result.size shouldBe 0
        }

        "parsing with unknown properties fails" {
            shouldThrow<IllegalArgumentException> {
                client.parseUri(URI("nop"), mapOf("a" to "b"))
            }
        }
    }
}
