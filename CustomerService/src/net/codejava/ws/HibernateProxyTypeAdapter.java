package net.codejava.ws;

import java.io.IOException;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class HibernateProxyTypeAdapter extends TypeAdapter<HibernateProxy> {
	
	public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
        @Override
        @SuppressWarnings("unchecked")
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            return (HibernateProxy.class.isAssignableFrom(type.getRawType()) ? (TypeAdapter<T>) new HibernateProxyTypeAdapter(gson) : null);
        }
    };
    private final Gson context;

    private HibernateProxyTypeAdapter(Gson context) {
        this.context = context;
    }
    
	@Override
	public void write(JsonWriter out, HibernateProxy value) throws IOException {
		
		// TODO Auto-generated method stub
		 if (value == null) {
	            out.nullValue();
	            return;
	        }
	        // Retrieve the original (not proxy) class
	        Class<?> baseType = Hibernate.getClass(value);
	        // Get the TypeAdapter of the original class, to delegate the serialization
	        TypeAdapter delegate = context.getAdapter(TypeToken.get(baseType));
	        // Get a filled instance of the original class
	        Object unproxiedValue = ((HibernateProxy) value).getHibernateLazyInitializer()
	                .getImplementation();
	        // Serialize the value
	        delegate.write(out, unproxiedValue);
	    }
		

	@Override
	public HibernateProxy read(JsonReader in) throws IOException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not supported");
	}

}
