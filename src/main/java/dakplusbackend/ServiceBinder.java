package dakplusbackend;

import java.util.HashMap;
import java.util.Map;

public class ServiceBinder {
    private static ServiceBinder serviceBinder;

    private Map<Class<?>, Object> bindableMap = new HashMap<Class<?>, Object>();

    public static ServiceBinder binder() {
        if (serviceBinder == null) serviceBinder = new ServiceBinder();
        return serviceBinder;
    }

    private ServiceBinder() {
        this.bindableMap = new HashMap<>();
        config();
    }

    /**
     * The {@link #config()} method reads the {@link Configuration} class to link the interfaces to the implementations.<p>
     * Currently all the implementations are "stub" classes (i.e. they provide the data needed but don't persist
     * the data to hard drive or database).
     */
    private void config() {
        Configuration.config(this);
    }

    protected  <T, S> void bind(Class<T> targetClazz, Class<S> implementationClazz) {
        try {

            Object implementationObject = implementationClazz.newInstance();
            bindableMap.put(targetClazz, implementationObject);

        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println("Something went horribly wrong creating an object of class: " + implementationClazz.toString());
        }
    }

    /**
     * {@link #getService(Class)} requests a service object of the given name.
     * @param clazz The name of the service
     * @return A bindable instance of the service requested.
     */
    public <T> T getService(Class<T> clazz) {
        return clazz.cast(bindableMap.get(clazz));
    }


}
