/**
*  Guest Presence sensor
*
*  Copyright 2018 Jmaxxz
*
*  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License. You may obtain a copy of the License at:
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
*  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
*  for the specific language governing permissions and limitations under the License.
*
*/

metadata {
	definition (name: "Guest Presence", namespace: "jmaxxz", author: "Jmaxxz", ocfDeviceType: "x.com.st.d.mobile.presence") {
		capability "Presence Sensor"
		capability "Sensor"
        capability "Switch"
	}

	simulator {
		status "present": "presence: 1"
		status "not present": "presence: 0"
	}

	tiles {
		standardTile("presence", "device.presence", width: 2, height: 2, canChangeBackground: true) {
			state("present", labelIcon:"st.presence.tile.mobile-present", backgroundColor:"#00A0DC")
			state("not present", labelIcon:"st.presence.tile.mobile-not-present", backgroundColor:"#ffffff")
		}
        standardTile("button", "device.switch", width: 2, height: 2, canChangeIcon: true) {
                state "off", label: 'Off', action: "switch.on", icon: "st.Kids.kid10", backgroundColor: "#ffffff", nextState: "on"
                state "on", label: 'On', action: "switch.off", icon: "st.Kids.kid10", backgroundColor: "#79b821", nextState: "off"
            }
		main "presence"
		details "presence", "button"
	}
}

def parse(String description) {
}

def on() {
    sendEvent(name: "switch", value: "on")
    sendEvent(name: "presence", value: "present")
}

def off() {
    sendEvent(name: "switch", value: "off")
    sendEvent(name: "presence", value: "not present")
}