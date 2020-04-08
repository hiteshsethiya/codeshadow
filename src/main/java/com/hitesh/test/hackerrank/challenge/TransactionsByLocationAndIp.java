package com.hitesh.test.hackerrank.challenge;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionsByLocationAndIp {

    /*
     * 1. Transactions by Location and IP
     *
     * In this challenge,
     * use the HTTP GET method to retrieve information from a database of Card Transactionsrecords for users.
     * Query https: //jsonmock.hackerrank.com/api/transactions/search?userId=uid
     * where uid is the value of user id passed to the function, to find all the records that belong to the user with id uid.
     * The query response is paginated and can be further accessed by appending to
     * the query string page=num where num is the page number.
     * The query response from the APIis a JSON response with the following five fields:
     * page: the current page
     * per_page: the maximum number of results per page
     * total: the total number of records in the search result
     * total_pages: the total number of pages which must be queried to get all the results
     * data: an array of JSON objects that contains transaction records.
     * The data field in the response contains a list of the transaction records,
     * with each transaction record following the below-described schema:
     *
     * id: the unique ID of the record
     * timestamp: the timestamp when the record was generated (InUTCmilliseconds)
     * userId: theuser id of the user who performed the transaction
     * userName: the user name of the user who performed the transaction
     * txnType: the transaction type of the transaction. Allowed values are debit and credit.
     * amount: the transaction amount. Stored as a string with the currency structure and prefixed with the $ sign, e.g. "$2,273.95".
     * location: object , the location description of the transaction location.
     *     id: The id of the location where the transaction took place location.
     *     address: The address of the location where the transaction took place location.
     *     city: The citywhere the transaction took place location.
     *     zipCode: The zip code of the location where the transaction took place
     *     ip: the IP address of the device which was used to perform the transaction
     *
     * Given the user-id uid, the provided location id locationId, the ip address range netStart to netEnd,
     * find and return the sum of the amount in the records that have the network prefix in the inclusive range
     * netStart to netEnd, belongs to the user uid and has been performed in the location with the id locationId.
     *
     * Note that the search is not case sensitive.
     *
     * NOTE :netStart and netEnd refer to the first byte of the IPV4 address.
     * So for example, to find the IP addresses in the range netStart and netEnd, take the first part of the IP address
     * 172.187.11.212 which is 172 and match if it belongs between the range netStart and netEnd.
     *
     * getTransactions has the following parameter(s):
     * int uid: the id by which record will be fetched
     * int locationId: the location id where the transaction took place
     * int netStart: the starting value (inclusive) of the network address for the device from which the transaction took place
     * int netEnd: the end value (inclusive) of the network address for the device from which the transaction took place
     *
     *     Returns:
     *     int:the sum of amount for all transaction which matches the filter criteria rounded to the nearest integer
     *
     * Input Format For Custom Testing
     * The first line contains an integer, uid.
     * The second line contains an integer, locationId.
     * The third line contains an integer, netStart.
     * The last line contains an integer, netEnd.
     *
     * Sample Case 0
     * Sample Input For Custom Testing
     * STDIN Function
     * -------------
     * 2→uid = 2
     * 8→locationId = 8
     * 5→netStart = 5
     * 50→netEnd = 50
     *
     * Sample Output 8446
     * Given
     * uid = 2 the query is
     * https://jsonmock.hackerrank.com/api/transactions/search?userId=2&page=1
     * and the response is:
     * [
     *    {
     *       "id":70,
     *       "userId":2,
     *       "userName":"Bob Martin",
     *       "timestamp":1550214607032,
     *       "txnType":"credit",
     *       "amount":"$2,411.06",
     *       "location":{
     *          "id":8,
     *          "address":"389, Everest, Barwell Terrace",
     *          "city":"Murillo",
     *          "zipCode":66061
     *       },
     *       "ip":"13.211.252.55"
     *    }
     * ]
     *
     * Apply the filter for netStartand netEnd, netStart is 5 and value of input netEnd is 50.
     * The first record has an IP address 13.211.252.55.
     * After formatting the IP address, the first byte is 13 which is between the range of netStart and netEnd.
     * Thus this record passes the filter criteria.
     * After applying this filter criteria for all the records with user ID 2 and location ID 8, there are 5 records.
     * The sum of the amounts in these 5 records is 8446, the final output.
     */

    public static class Location implements Serializable {
        public Integer id;
        public String address;
        public String city;
        public String zipCode;
    }

    public static class Transaction implements Serializable {
        public Integer id;
        public String userId;
        public String userName;
        public String timestamp;
        public String txnType;
        public String amount;
        public String ip;
        public Location location;
    }

    public static class PaginatedTransaction implements Serializable {
        public String page;
        public int per_page;
        public int total;
        public int total_pages;
        public List<Transaction> data;
    }

    public static Double getCleansedNumber(String str) {
        str = str.replaceAll("[^-?0-9.]+", "");
        return Double.parseDouble(str);
    }

    public static boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }

    public static String getParamsString(Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            result.append("&");
        }

        String resultString = result.toString();
        return resultString.length() > 0
                ? resultString.substring(0, resultString.length() - 1)
                : resultString;
    }

    public static boolean isSuccessful(int statusCode) {
        return 200 <= statusCode && statusCode < 300;
    }

    public static PaginatedTransaction fetchTransactions(String endpoint,
                                                         String userId,
                                                         int pageNo,
                                                         int pageSize) throws IOException {
        if (isEmpty(userId) || pageNo <= 0 || pageSize <= 0) return null;

        Map<String, String> parameters = new HashMap<>();
        parameters.put("userId", userId);
        parameters.put("page", pageNo + "");
        parameters.put("per_page", pageSize + "");
        URL url;
        HttpURLConnection connection = null;
        BufferedReader in = null;
        try {
            endpoint += "?" + getParamsString(parameters);
            url = new URL(endpoint);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setInstanceFollowRedirects(false);

            int status = connection.getResponseCode();

            if (isSuccessful(status)) {
                in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);

                }
                Gson gson = new Gson();
                return gson.fromJson(content.toString(), PaginatedTransaction.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }


    public static Double getTotalFromTransactions(List<Transaction> transactions,
                                                  int locationId,
                                                  int netStart,
                                                  int netEnd) {
        Double total = 0.0;

        for (Transaction iTransaction : transactions) {
            if (iTransaction.location.id.equals(locationId) && isIpInRange(netStart, netEnd, iTransaction.ip)) {
//                System.out.println("id -> " + iTransaction.id + " amount -> " + iTransaction.amount);
                total += getCleansedNumber(iTransaction.amount);
            }
        }
        return total;
    }

    public static boolean isIpInRange(int netStart, int netEnd, String ipAddress) {
        int ipStart = Integer.parseInt(ipAddress.trim().split("\\.")[0]);
        return netStart <= ipStart && ipStart <= netEnd;
    }

    public static int getTransactions(int userId, int locationId, int netStart, int netEnd) {
        try {
            final String url = "https://jsonmock.hackerrank.com/api/transactions/search";
            Double totalAmount = 0.0;
            int totalPages = 1, pageSize = 100;
            for (int page = 1; page <= totalPages; ++page) {
                PaginatedTransaction paginatedTransaction = fetchTransactions(url, userId + "", page, pageSize);
                if (paginatedTransaction == null) continue;
//                System.out.println(gson.toJson(paginatedTransaction));
                totalPages = paginatedTransaction.total_pages;
                pageSize = paginatedTransaction.per_page;
                totalAmount += getTotalFromTransactions(paginatedTransaction.data,
                        locationId, netStart, netEnd);
            }
            return (int) Math.round(totalAmount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(getTransactions(2, 8, 5, 50));
    }

}