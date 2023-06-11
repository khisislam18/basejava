/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int ind = 0;

    void clear() {
        storage = new Resume[10000];
        ind = 0;
    }

    void save(Resume r) {
        storage[ind++] = r;
    }

    Resume get(String uuid) {
        for (int i = 0; i < ind; i++) {
            if(uuid.equals(storage[i].uuid)){
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < ind; i++) {
            if(uuid.equals(storage[i].uuid)){
                Resume tmp = storage[i];
                storage[i] = storage[ind - 1];
                storage[ind - 1] = tmp;
                ind--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] tmpRes = new Resume[ind];
        System.arraycopy(storage, 0,tmpRes,0,ind);
        return tmpRes;
    }

    int size() {
        return ind;
    }
}
