package io.patrykpoborca.cleanarchitecture.mockimpl;

import io.patrykpoborca.cleanarchitecture.network.base.OKHttp;
import io.patrykpoborca.cleanarchitecture.network.base.Retrofit;
import rx.Observable;
import rx.Scheduler;

public class MockRetrofit extends Retrofit {
    private static final String MOCK_PARSE = "SomeMockResponse";
    public static final String MOCKED_STRING = "MOCKED PAGE:";

    public MockRetrofit(OKHttp okHttp, Scheduler mainScheduler) {
        super(okHttp, mainScheduler);
    }

    @Override
    public Observable<String> completeRequest() {
        return Observable.just(okHttp.rawResponse() + MOCK_PARSE)
                .observeOn(mainScheduler);
    }

    @Override
    public Observable<String> fetchSomePage(String url) {
        return Observable.just("<h2>" + MOCKED_STRING + " " + url + " </h2>")
                .observeOn(mainScheduler);
    }
}
