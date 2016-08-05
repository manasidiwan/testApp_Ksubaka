package com.manasidiwan.android.testapp.Modal.Common;

import android.app.Application;

import com.google.inject.AbstractModule;
import com.manasidiwan.android.testapp.Logic.UserModel;
import com.manasidiwan.android.testapp.Logic.UserModelImpl;
import com.manasidiwan.android.testapp.Logic.UserProvider;
import com.manasidiwan.android.testapp.Logic.UserProviderImpl;
import com.manasidiwan.android.testapp.UI.Detail.DetailPresenter;
import com.manasidiwan.android.testapp.UI.Detail.Impl.DetailPresenterImpl;
import com.manasidiwan.android.testapp.UI.Home.HomePresenter;
import com.manasidiwan.android.testapp.UI.Home.Impl.HomePresenterImpl;

/**
 * @author manasidiwan
 */
public class RoboConfigModule extends AbstractModule {

    /**
     * Constructor
     *
     * @param app application context
     */
    public RoboConfigModule(final Application app) {
    }

    @Override
    protected void configure() {
        bind(HomePresenter.class).to(HomePresenterImpl.class);
        bind(DetailPresenter.class).to(DetailPresenterImpl.class);
        bind(UserProvider.class).to(UserProviderImpl.class);
        bind(UserModel.class).to(UserModelImpl.class);
    }
}
