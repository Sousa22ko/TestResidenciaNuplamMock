package exemplo1;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

interface MockExample {
   int getInt();
   Integer getInteger();
   double getDouble();
   boolean getBoolean();
   String getObject();
   Collection<String> getCollection();
   String[] getArray();
   Stream<?> getStream();
   Optional<?> getOptional();
}	