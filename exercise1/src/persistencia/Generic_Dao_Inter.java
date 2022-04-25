
package persistencia;

import java.util.List;

public interface Generic_Dao_Inter <T> {
    public void saveObjeto(T t);
    public void deleteObjeto(T t);
    public void updateObjeto(T t);
    public T getObjeto(int id);
    public List<T> getAll();
}
