package com.warren.fleet.grpc.hello;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: hello.proto")
public final class GeeterGrpc {

  private GeeterGrpc() {}

  public static final String SERVICE_NAME = "helloworld.Geeter";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSayHelloMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.warren.fleet.grpc.hello.HelloGreeting,
      com.warren.fleet.grpc.hello.HelloReply> METHOD_SAY_HELLO = getSayHelloMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.warren.fleet.grpc.hello.HelloGreeting,
      com.warren.fleet.grpc.hello.HelloReply> getSayHelloMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.warren.fleet.grpc.hello.HelloGreeting,
      com.warren.fleet.grpc.hello.HelloReply> getSayHelloMethod() {
    return getSayHelloMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.warren.fleet.grpc.hello.HelloGreeting,
      com.warren.fleet.grpc.hello.HelloReply> getSayHelloMethodHelper() {
    io.grpc.MethodDescriptor<com.warren.fleet.grpc.hello.HelloGreeting, com.warren.fleet.grpc.hello.HelloReply> getSayHelloMethod;
    if ((getSayHelloMethod = GeeterGrpc.getSayHelloMethod) == null) {
      synchronized (GeeterGrpc.class) {
        if ((getSayHelloMethod = GeeterGrpc.getSayHelloMethod) == null) {
          GeeterGrpc.getSayHelloMethod = getSayHelloMethod = 
              io.grpc.MethodDescriptor.<com.warren.fleet.grpc.hello.HelloGreeting, com.warren.fleet.grpc.hello.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "helloworld.Geeter", "SayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.warren.fleet.grpc.hello.HelloGreeting.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.warren.fleet.grpc.hello.HelloReply.getDefaultInstance()))
                  .setSchemaDescriptor(new GeeterMethodDescriptorSupplier("SayHello"))
                  .build();
          }
        }
     }
     return getSayHelloMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GeeterStub newStub(io.grpc.Channel channel) {
    return new GeeterStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GeeterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GeeterBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GeeterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GeeterFutureStub(channel);
  }

  /**
   */
  public static abstract class GeeterImplBase implements io.grpc.BindableService {

    /**
     */
    public void sayHello(com.warren.fleet.grpc.hello.HelloGreeting request,
        io.grpc.stub.StreamObserver<com.warren.fleet.grpc.hello.HelloReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSayHelloMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.warren.fleet.grpc.hello.HelloGreeting,
                com.warren.fleet.grpc.hello.HelloReply>(
                  this, METHODID_SAY_HELLO)))
          .build();
    }
  }

  /**
   */
  public static final class GeeterStub extends io.grpc.stub.AbstractStub<GeeterStub> {
    private GeeterStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GeeterStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GeeterStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GeeterStub(channel, callOptions);
    }

    /**
     */
    public void sayHello(com.warren.fleet.grpc.hello.HelloGreeting request,
        io.grpc.stub.StreamObserver<com.warren.fleet.grpc.hello.HelloReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSayHelloMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GeeterBlockingStub extends io.grpc.stub.AbstractStub<GeeterBlockingStub> {
    private GeeterBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GeeterBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GeeterBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GeeterBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.warren.fleet.grpc.hello.HelloReply sayHello(com.warren.fleet.grpc.hello.HelloGreeting request) {
      return blockingUnaryCall(
          getChannel(), getSayHelloMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GeeterFutureStub extends io.grpc.stub.AbstractStub<GeeterFutureStub> {
    private GeeterFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GeeterFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GeeterFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GeeterFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.warren.fleet.grpc.hello.HelloReply> sayHello(
        com.warren.fleet.grpc.hello.HelloGreeting request) {
      return futureUnaryCall(
          getChannel().newCall(getSayHelloMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GeeterImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GeeterImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((com.warren.fleet.grpc.hello.HelloGreeting) request,
              (io.grpc.stub.StreamObserver<com.warren.fleet.grpc.hello.HelloReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GeeterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GeeterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.warren.fleet.grpc.hello.HelloProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Geeter");
    }
  }

  private static final class GeeterFileDescriptorSupplier
      extends GeeterBaseDescriptorSupplier {
    GeeterFileDescriptorSupplier() {}
  }

  private static final class GeeterMethodDescriptorSupplier
      extends GeeterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GeeterMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GeeterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GeeterFileDescriptorSupplier())
              .addMethod(getSayHelloMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
