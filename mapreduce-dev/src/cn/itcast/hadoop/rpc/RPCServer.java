package cn.itcast.hadoop.rpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Server;

public class RPCServer implements Bizable{
	
	public String sayHi(String name){
		return "HI ~ " + name;
	}

	public static void main(String[] args) throws Exception {
		Server server= new RPC.Builder(new Configuration()).setInstance(new RPCServer()).setProtocol(Bizable.class).setBindAddress("192.168.8.118").setPort(9527).build();
		server.start();
	}

}
