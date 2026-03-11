package xyz.vmartinez84.holamundospinnerv1.services;

public interface ApiCallback<T>{
    void onSuccess(T result);
    void onError(String errorMessage);
}
