package com.interviewcake.evgenyk.mergingmeetingtime;


import com.interviewcake.evgenyk.Utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * https://www.interviewcake.com/question/java/merging-ranges
 */
class Main {
    static List<Meeting> mergeRanges(List<Meeting> arr) {
        List<Meeting> sorted = arr.stream().sorted(Comparator.comparingInt(Meeting::getStartTime)).collect(Collectors.toList());
        List<Meeting> res = new ArrayList<>();
        mergeRange(Utils.head(sorted), Utils.tail(sorted), res);
        return res;
    }

    private static void mergeRange(Meeting currentMeeting, List<Meeting> arr, List<Meeting> res) {
        if (arr.isEmpty()) {
            res.add(currentMeeting);
            return;
        }
        Meeting head = Utils.head(arr);
        Meeting mergedMeeting = mergeTwoMeetings(currentMeeting, head);
        if (mergedMeeting == currentMeeting) {
            res.add(mergedMeeting);
            mergeRange(head, Utils.tail(arr), res);
        } else {
            mergeRange(mergedMeeting, Utils.tail(arr), res);
        }
    }

    private static Meeting mergeTwoMeetings(Meeting x, Meeting y) {
        if (x.getEndTime() < y.getStartTime())
            return x;
//        if (y.getEndTime() < x.getStartTime())
//            return y;
        return new Meeting(Math.min(x.getStartTime(), y.getStartTime()), Math.max(x.getEndTime(), y.getEndTime()));
    }
}

class Meeting {

    private int startTime;
    private int endTime;

    public Meeting(int startTime, int endTime) {
        // number of 30 min blocks past 9:00 am
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "[" + startTime + "->" + endTime + "] ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return startTime == meeting.startTime && endTime == meeting.endTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, endTime);
    }
}