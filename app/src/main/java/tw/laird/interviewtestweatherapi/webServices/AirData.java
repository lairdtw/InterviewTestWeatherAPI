package tw.laird.interviewtestweatherapi.webServices;

import java.util.List;

public class AirData {

    /**
     * success : true
     * result : {"resource_id":"F-C0032-001","fields":[{"id":"datasetDescription","type":"String"},{"id":"locationName","type":"String"},{"id":"parameterName","type":"String"},{"id":"parameterValue","type":"String"},{"id":"parameterUnit","type":"String"},{"id":"startTime","type":"Timestamp"},{"id":"endTime","type":"Timestamp"}]}
     * records : {"datasetDescription":"三十六小時天氣預報","location":[{"locationName":"臺北市","weatherElement":[{"elementName":"MinT","time":[{"startTime":"2020-05-11 12:00:00","endTime":"2020-05-11 18:00:00","parameter":{"parameterName":"27","parameterUnit":"C"}},{"startTime":"2020-05-11 18:00:00","endTime":"2020-05-12 06:00:00","parameter":{"parameterName":"24","parameterUnit":"C"}},{"startTime":"2020-05-12 06:00:00","endTime":"2020-05-12 18:00:00","parameter":{"parameterName":"24","parameterUnit":"C"}}]}]}]}
     */

    private String success;
    private ResultBean result;
    private RecordsBean records;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public RecordsBean getRecords() {
        return records;
    }

    public void setRecords(RecordsBean records) {
        this.records = records;
    }

    public static class ResultBean {
        /**
         * resource_id : F-C0032-001
         * fields : [{"id":"datasetDescription","type":"String"},{"id":"locationName","type":"String"},{"id":"parameterName","type":"String"},{"id":"parameterValue","type":"String"},{"id":"parameterUnit","type":"String"},{"id":"startTime","type":"Timestamp"},{"id":"endTime","type":"Timestamp"}]
         */

        private String resource_id;
        private List<FieldsBean> fields;

        public String getResource_id() {
            return resource_id;
        }

        public void setResource_id(String resource_id) {
            this.resource_id = resource_id;
        }

        public List<FieldsBean> getFields() {
            return fields;
        }

        public void setFields(List<FieldsBean> fields) {
            this.fields = fields;
        }

        public static class FieldsBean {
            /**
             * id : datasetDescription
             * type : String
             */

            private String id;
            private String type;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }

    public static class RecordsBean {
        /**
         * datasetDescription : 三十六小時天氣預報
         * location : [{"locationName":"臺北市","weatherElement":[{"elementName":"MinT","time":[{"startTime":"2020-05-11 12:00:00","endTime":"2020-05-11 18:00:00","parameter":{"parameterName":"27","parameterUnit":"C"}},{"startTime":"2020-05-11 18:00:00","endTime":"2020-05-12 06:00:00","parameter":{"parameterName":"24","parameterUnit":"C"}},{"startTime":"2020-05-12 06:00:00","endTime":"2020-05-12 18:00:00","parameter":{"parameterName":"24","parameterUnit":"C"}}]}]}]
         */

        private String datasetDescription;
        private List<LocationBean> location;

        public String getDatasetDescription() {
            return datasetDescription;
        }

        public void setDatasetDescription(String datasetDescription) {
            this.datasetDescription = datasetDescription;
        }

        public List<LocationBean> getLocation() {
            return location;
        }

        public void setLocation(List<LocationBean> location) {
            this.location = location;
        }

        public static class LocationBean {
            /**
             * locationName : 臺北市
             * weatherElement : [{"elementName":"MinT","time":[{"startTime":"2020-05-11 12:00:00","endTime":"2020-05-11 18:00:00","parameter":{"parameterName":"27","parameterUnit":"C"}},{"startTime":"2020-05-11 18:00:00","endTime":"2020-05-12 06:00:00","parameter":{"parameterName":"24","parameterUnit":"C"}},{"startTime":"2020-05-12 06:00:00","endTime":"2020-05-12 18:00:00","parameter":{"parameterName":"24","parameterUnit":"C"}}]}]
             */

            private String locationName;
            private List<WeatherElementBean> weatherElement;

            public String getLocationName() {
                return locationName;
            }

            public void setLocationName(String locationName) {
                this.locationName = locationName;
            }

            public List<WeatherElementBean> getWeatherElement() {
                return weatherElement;
            }

            public void setWeatherElement(List<WeatherElementBean> weatherElement) {
                this.weatherElement = weatherElement;
            }

            public static class WeatherElementBean {
                /**
                 * elementName : MinT
                 * time : [{"startTime":"2020-05-11 12:00:00","endTime":"2020-05-11 18:00:00","parameter":{"parameterName":"27","parameterUnit":"C"}},{"startTime":"2020-05-11 18:00:00","endTime":"2020-05-12 06:00:00","parameter":{"parameterName":"24","parameterUnit":"C"}},{"startTime":"2020-05-12 06:00:00","endTime":"2020-05-12 18:00:00","parameter":{"parameterName":"24","parameterUnit":"C"}}]
                 */

                private String elementName;
                private List<TimeBean> time;

                public String getElementName() {
                    return elementName;
                }

                public void setElementName(String elementName) {
                    this.elementName = elementName;
                }

                public List<TimeBean> getTime() {
                    return time;
                }

                public void setTime(List<TimeBean> time) {
                    this.time = time;
                }

                public static class TimeBean {
                    /**
                     * startTime : 2020-05-11 12:00:00
                     * endTime : 2020-05-11 18:00:00
                     * parameter : {"parameterName":"27","parameterUnit":"C"}
                     */

                    private String startTime;
                    private String endTime;
                    private ParameterBean parameter;

                    public String getStartTime() {
                        return startTime;
                    }

                    public void setStartTime(String startTime) {
                        this.startTime = startTime;
                    }

                    public String getEndTime() {
                        return endTime;
                    }

                    public void setEndTime(String endTime) {
                        this.endTime = endTime;
                    }

                    public ParameterBean getParameter() {
                        return parameter;
                    }

                    public void setParameter(ParameterBean parameter) {
                        this.parameter = parameter;
                    }

                    public static class ParameterBean {
                        /**
                         * parameterName : 27
                         * parameterUnit : C
                         */

                        private String parameterName;
                        private String parameterUnit;

                        public String getParameterName() {
                            return parameterName;
                        }

                        public void setParameterName(String parameterName) {
                            this.parameterName = parameterName;
                        }

                        public String getParameterUnit() {
                            return parameterUnit;
                        }

                        public void setParameterUnit(String parameterUnit) {
                            this.parameterUnit = parameterUnit;
                        }
                    }

                    @Override
                    public String toString() {
                        return "TimeBean{" +
                                "startTime='" + startTime + '\'' +
                                ", endTime='" + endTime + '\'' +
                                ", parameter=" + parameter +
                                '}';
                    }
                }

                @Override
                public String toString() {
                    return "WeatherElementBean{" +
                            "elementName='" + elementName + '\'' +
                            ", time=" + time +
                            '}';
                }
            }

            @Override
            public String toString() {
                return "LocationBean{" +
                        "locationName='" + locationName + '\'' +
                        ", weatherElement=" + weatherElement +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "RecordsBean{" +
                    "datasetDescription='" + datasetDescription + '\'' +
                    ", location=" + location +
                    '}';
        }
    }
}
