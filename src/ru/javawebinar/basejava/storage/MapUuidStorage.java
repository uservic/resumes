package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage {
    private Map<String, Resume> storage = new HashMap<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected List<Resume> doListCopy() {
        return new ArrayList<>(storage.values());
    }

    @Override
    protected void doSave(Object index, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume doGet(Object key) {
        return storage.get(key);
    }

    @Override
    protected void doUpdate(Object key, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void doDelete(Object key) {
        storage.remove(key);
    }

    @Override
    protected boolean keyExist(Object key) {
        return key != null;
    }

    @Override
    protected String getKey(String uuid) {
        return storage.containsKey(uuid) ? uuid : null;
    }
}