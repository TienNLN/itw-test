package com.tiennln.itwcdg;

/**
 * @author TienNLN on 18/01/2023
 */

import java.util.*;
import java.text.SimpleDateFormat;

public class CarRental {
    public static Boolean canScheduleAll(Collection<RentalTime> rentalTimes) {
        return isOverlap(rentalTimes);
    }

    private static Boolean isOverlap(Collection<RentalTime> processCollection) {

        List<RentalTime> processList = processCollection.stream().toList();

        for (int i = 1; i < processList.size(); i++) {
            if ((processList.get(0).getStart().before(processList.get(i).getStart())
                    && processList.get(0).getStart().after(processList.get(i).getStart())
                    && processList.get(0).getEnd().before(processList.get(i).getEnd()))
                    || (processList.get(0).getStart().after(processList.get(i).getStart())
                        && processList.get(0).getStart().before(processList.get(i).getEnd())
                        && processList.get(0).getEnd().after(processList.get(i).getEnd()))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y H:m");

        ArrayList<RentalTime> rentalTimes = new ArrayList<RentalTime>();
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 19:00"), sdf.parse("03/05/2020 20:30")));
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 22:10"), sdf.parse("03/05/2020 22:30")));
        rentalTimes.add(new RentalTime(sdf.parse("03/05/2020 20:30"), sdf.parse("03/05/2020 22:00")));
        rentalTimes.add(new RentalTime(sdf.parse("04/05/2020 20:30"), sdf.parse("03/05/2020 22:00")));
        rentalTimes.add(new RentalTime(sdf.parse("04/05/2020 19:30"), sdf.parse("03/05/2020 23:00")));
        rentalTimes.add(new RentalTime(sdf.parse("04/05/2020 21:30"), sdf.parse("03/05/2020 24:00")));
        rentalTimes.add(new RentalTime(sdf.parse("04/05/2020 23:30"), sdf.parse("03/05/2020 1:00")));

        System.out.println(canScheduleAll(rentalTimes));
    }
}

class RentalTime {
    private Date start, end;

    public RentalTime(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return this.start;
    }

    public Date getEnd() {
        return this.end;
    }
}