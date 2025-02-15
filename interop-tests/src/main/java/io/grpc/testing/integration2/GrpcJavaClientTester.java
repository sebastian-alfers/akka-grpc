/*
 * Copyright (C) 2018-2024 Lightbend Inc. <https://www.lightbend.com>
 */

package io.grpc.testing.integration2;

import io.grpc.ManagedChannelBuilder;
import io.grpc.testing.integration.AbstractInteropTest;

/**
 * Implementation of ClientTester that forwards all calls to the
 * grpc-java AbstractInteropTest.
 */
public class GrpcJavaClientTester implements ClientTester {

    final private Settings settings;

    private final UnderlyingTester tester = new UnderlyingTester();

    public GrpcJavaClientTester(Settings settings) {
        this.settings = settings;
    }


    @Override
    public void setUp() {
        tester.setUp();
    }

    @Override
    public void tearDown() throws Exception {
        tester.tearDown();
    }


    @Override
    public void emptyUnary() throws Exception {
        tester.emptyUnary();
    }

    @Override
    public void largeUnary() throws Exception {
        tester.largeUnary();
    }

    @Override
    public void clientCompressedUnary(boolean probe) throws Exception {
        tester.clientCompressedUnary(probe);
    }

    @Override
    public void serverCompressedUnary() throws Exception {
        tester.serverCompressedUnary();
    }

    @Override
    public void clientStreaming() throws Exception {
        tester.clientStreaming();
    }

    @Override
    public void clientCompressedStreaming(boolean probe) throws Exception {
        tester.clientCompressedStreaming(probe);
    }

    @Override
    public void serverStreaming() throws Exception {
        tester.serverStreaming();
    }

    @Override
    public void serverCompressedStreaming() throws Exception {
        tester.serverCompressedStreaming();
    }

    @Override
    public void pingPong() throws Exception {
        tester.pingPong();
    }

    @Override
    public void emptyStream() throws Exception {
        tester.emptyStream();
    }

    @Override
    public void customMetadata() throws Exception {
        tester.customMetadata();
    }

    @Override
    public void statusCodeAndMessage() throws Exception {
        tester.statusCodeAndMessage();
    }

    @Override
    public void unimplementedMethod() {
        tester.unimplementedMethod();
    }

    @Override
    public void unimplementedService() {
        tester.unimplementedService();
    }

    @Override
    public void cancelAfterBegin() throws Exception {
        tester.cancelAfterBegin();
    }

    @Override
    public void cancelAfterFirstResponse() throws Exception {
        tester.cancelAfterFirstResponse();
    }

    @Override
    public void timeoutOnSleepingServer() throws Exception {
        tester.timeoutOnSleepingServer();
    }

    public final class UnderlyingTester extends AbstractInteropTest {
        @Override
        protected ManagedChannelBuilder<?> createChannelBuilder() {
            return ChannelBuilder.create(settings);
        }

        @Override
        protected boolean metricsExpected() {
            // Server-side metrics won't be found, because server is a separate process.
            return false;
        }
    }

}
