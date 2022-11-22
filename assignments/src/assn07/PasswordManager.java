package assn07;

import java.util.*;

public class PasswordManager<K,V> implements Map<K,V> {
    private static final String MASTER_PASSWORD = "password123";
    private Account[] _passwords;

    public PasswordManager() {
        _passwords = new Account[50];
    }

    private int hashKey(K key){
        return Math.abs(key.hashCode() % 50);
//        return key.hashCode() % 50 < 0 ? key.hashCode() % 50 + 50: key.hashCode() % 50;
    }


    @Override
    public void put(K key, V value) {
        if (key == null || value == null){
            return ;
        }
        int keyIndex = hashKey(key);
        Account newAccount = new Account(key, value);
        if (this._passwords[keyIndex] != null) {
            Account account = this._passwords[keyIndex];
            while (account != null){
                if (account.getWebsite().equals(key)){
                    account.setPassword(value);
                    return;
                }
                account = account.getNext();
            }
            newAccount.setNext(this._passwords[keyIndex]);
        }
        this._passwords[keyIndex] = newAccount;
    }


    @Override
    public V get(K key) {
        if (key == null){
            return null;
        }
        int keyIndex = hashKey(key);
        Account account = this._passwords[keyIndex];
        if (account != null) {
            while (account != null){
                if (account.getWebsite().equals(key)){
                    return (V) account.getPassword();
                }
                account = account.getNext();
            }
        }
        return null;
    }


    @Override
    public int size() {
        int size = 0;
        for (int i = 0; i < 50; i++) {
            Account account = this._passwords[i];
            if (account != null) {
                while (account != null){
                    size++;
                    account = account.getNext();
                }
            }
        }
        return size;
    }


    @Override
    public Set<K> keySet() {
        Set<K> sites = (Set<K>) new HashSet<String>();
        for (int i = 0; i < 50; i++) {
            if (this._passwords[i] != null){
                Account account = this._passwords[i];
                while (account != null){
                    sites.add((K) account.getWebsite());
                    account = account.getNext();
                }
            }
        }
        return sites;
    }


    @Override
    public V remove(K key) {
        int keyIndex = hashKey(key);
        Account account = this._passwords[keyIndex];
        if (account != null){
            if (account.getWebsite().equals(key)) {
                this._passwords[keyIndex] = account.getNext();
                return (V) account.getPassword();
            }
            Account nextAccount = account.getNext();
            while (nextAccount != null) {
                if (nextAccount.getWebsite().equals(key)){
                    account.setNext(nextAccount.getNext());
                    return (V) nextAccount.getPassword();
                }
                account = account.getNext();
                nextAccount = nextAccount.getNext();
            }
        }
        return null;
    }


    @Override
    public List<K> checkDuplicate(V value) {
        if (value == null){
            return null;
        }
        List<K> sites = new ArrayList<K>();
        for (int i = 0; i < 50; i++) {
            if (this._passwords[i] != null){
                Account account = this._passwords[i];
                while (account != null){
                    if (account.getPassword().equals(value)){
                        sites.add((K) account.getWebsite());
                    }
                    account = account.getNext();
                }
            }
        }
        return sites;
    }


    @Override
    public boolean checkMasterPassword(String enteredPassword) {
        return MASTER_PASSWORD.equals(enteredPassword);
    }

    /*
    Generates random password of input length
     */
    @Override
    public String generateRandomPassword(int length) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = length;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    /*
    Used for testing, do not change
     */
    public Account[] getPasswords() {
        return _passwords;
    }
}
