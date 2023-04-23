package jp.jaxa.iss.kibo.rpc.defaultapk;

import jp.jaxa.iss.kibo.rpc.api.KiboRpcService;

/**
 * Class meant to handle commands from the Ground Data System and execute them in Astrobee
 */

public class YourService extends KiboRpcService {
    @Override
    protected void runPlan1(){
        // write your plan 1 here
        // the mission starts
        api.startMission();
        int loop_counter = 0;
        while (true) {
            // get the list of active target id
            List<Integer> list = api.getActiveTargets();
            // move to a point
            Point point = new Point(10.4d, -10.1d, 4.47d);
            Quaternion quaternion = new Quaternion(0f, 0f, 0f, 1f);
            api.moveTo(point, quaternion, false);
            // get a camera image
            Mat image = api.getMatNavCam();
            // irradiate the laser
            api.laserControl(true);
            // take active target snapshots
            int target_id = 1;
            api.takeTargetSnapshot(target_id);
            /* ************************************************ */
            /* write your own code and repair the ammonia leak! */
            /* ************************************************ */
            // get remaining active time and mission time
            List<Long> timeRemaining = api.getTimeRemaining();
            // check the remaining milliseconds of mission time
            if (timeRemaining.get(1) < 60000) {
            }
        }
    }

    @Override
    protected void runPlan2(){
        // write your plan 2 here
    }

    @Override
    protected void runPlan3(){
        // write your plan 3 here
    }

}

