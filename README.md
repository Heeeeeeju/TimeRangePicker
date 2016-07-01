# TimeRangePicker

## Description
This library provides a dialog which has two taps, from(start) time and to(end) time

## Sample Example

    dialog = new DialogTimeRangePicker(MainActivity.this);
    dialog.show();
    dialog.setVisibleTo(true);
    dialog.setTimeFrom(5, 0);
    dialog.setTimeTo(6, 30);
    dialog.setConfirmListener(new DialogTimeRangePicker.onConfirmListener() {
	    @Override
	    public void confirmEvent(int fromHour, int fromMin, int toHour, int toMin) {
	    	Toast.makeText(getApplicationContext(),
		    		String.format("%02d:%02d ~ %02d:%02d", fromHour, fromMin, toHour, toMin),
			    	Toast.LENGTH_SHORT).show();
	    }
    });

## Sample Result
![alt tag](https://github.com/Heeeeeeju/TimeRangePicker/blob/master/SampleImage/500.jpg)
![alt tag](https://github.com/Heeeeeeju/TimeRangePicker/blob/master/SampleImage/630.jpg)

## License

    Copyright 2016 Heeeeeeju (TimeRangePicker)
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
       http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.