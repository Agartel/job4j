package ru.job4j.collectionspro.generics;

public abstract class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> array = new SimpleArray<>();

    @Override
    public void add(T model) {
        array.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int cnt = 0;
        boolean res = false;
        for (T elem : array) {
            if (elem.getId().equals(id)) {
                array.set(cnt, model);
                res = true;
                break;

            }
            cnt++;
        }
        return true;
    }

    @Override
    public boolean delete(String id) {
        int cnt = 0;
        boolean res = false;
        for (T elem : array) {
            if (elem.getId().equals(id)) {
                array.remove(cnt);
                res = true;
                break;

            }
            cnt++;
        }

        return res;
    }

    @Override
    public T findById(String id) {
        T result = null;
        for (T elem : array) {
            if (elem.getId().equals(id)) {
                result = elem;
                break;

            }
        }
        return result;
    }
}
