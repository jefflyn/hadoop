package cn.itcast.hadoop.rpc;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

public class RPCClient {

	public static void main(String[] args) throws IOException {
		Bizable proxy = RPC.getProxy(Bizable.class, 10010,new InetSocketAddress("192.168.8.118", 9527), new Configuration());
		String result = proxy.sayHi(args[0]);
		System.out.println(result);
		RPC.stopProxy(proxy);
	}

}
