package com.app.factory;

import lombok.AllArgsConstructor;

import static com.app.utils.ResourceUtil.getConfigPropertyValue;
import static org.apache.commons.lang3.StringUtils.EMPTY;

@AllArgsConstructor
public class UrlFactory {
    private final String env;

    /**
     * in case of multiple working urls: use urlPoint parameter fot this method and all possible values inside switch
     *
     * @param //urlPoint
     */
    public String getUrl() {
//        switch (urlPoint) {
//            case "addressbook":
//                return String.format(getConfigPropertyValue("baseurl.addressbook"), env);
//            case "gateway":
//                return String.format(getConfigPropertyValue("baseurl.payments-services-auth"), env);
//            default:
//                return EMPTY;
//        }
        return String.format(getConfigPropertyValue("baseurl.addressbook"), env);
    }
}
