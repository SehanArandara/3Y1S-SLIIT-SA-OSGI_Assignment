package osgi_servicesubscriber;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import osgi_servicepublisher.ServicePublish;

public class ServiceActivator implements BundleActivator {

	ServiceReference serviceReference;
	
	public void start(BundleContext context) throws Exception {
		System.out.println("start subscriber service");
		serviceReference= context.getServiceReference(ServicePublish.class.getName());
		
		ServicePublish servicePublish = (ServicePublish)context.getService(serviceReference);
		System.out.println(servicePublish.publishService());
		
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("good by service ");
		context.ungetService(serviceReference);
		
	}

}
