import * as sdk from "kmp-js-lib";
export function getLaunches() {
    return sdk.com.softmoon.ktorkmm.data.services.LaunchServiceWrapper.getLaunches();
}