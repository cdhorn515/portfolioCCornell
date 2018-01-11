package com.cdhorn.ControllerTests;

import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class StandAloneMvcTestViewResolver extends InternalResourceViewResolver {

    public StandAloneMvcTestViewResolver() {
        super();
    }

    @Override
    protected AbstractUrlBasedView buildView(String viewName) throws Exception {
        final InternalResourceView view = (InternalResourceView) super.buildView(viewName);
        view.setPreventDispatchLoop(false);
        return view;
    }
}
