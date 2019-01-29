package io.openems.edge.battery.soltaro.versionb;

import java.util.Arrays;
import java.util.stream.Stream;

import io.openems.edge.battery.api.Battery;
import io.openems.edge.battery.soltaro.versionb.SoltaroRackVersionB;
import io.openems.edge.common.channel.AbstractReadChannel;
import io.openems.edge.common.channel.BooleanReadChannel;
import io.openems.edge.common.channel.IntegerReadChannel;
import io.openems.edge.common.channel.IntegerWriteChannel;
import io.openems.edge.common.channel.StateChannel;
import io.openems.edge.common.channel.StateCollectorChannel;
import io.openems.edge.common.component.OpenemsComponent;

public class Utils {
	
	public static Stream<? extends AbstractReadChannel<?>> initializeChannels(SoltaroRackVersionB s) {
		// Define the channels. Using streams + switch enables Eclipse IDE to tell us if
		// we are missing an Enum value.
		return Stream.of( //
				Arrays.stream(OpenemsComponent.ChannelId.values()).map(channelId -> {
					switch (channelId) {
					case STATE:
						return new StateCollectorChannel(s, channelId);
					}
					return null;
				}), Arrays.stream(Battery.ChannelId.values()).map(channelId -> {
					switch (channelId) {
					case SOC:
					case SOH:
//					case BATTERY_TEMP:
//					case MAX_CAPACITY:
					case MIN_CELL_VOLTAGE:
					case VOLTAGE:
					case CURRENT:
					case MAX_CELL_TEMPERATURE:
					case MAX_CELL_VOLTAGE:
					case MAX_POWER:
					case MIN_CELL_TEMPERATURE:
						return new IntegerReadChannel(s, channelId);
					case CHARGE_MAX_CURRENT:
						return new IntegerReadChannel(s, channelId, SoltaroRackVersionB.CHARGE_MAX_A);
					case CHARGE_MAX_VOLTAGE:
						return new IntegerReadChannel(s, channelId, SoltaroRackVersionB.CHARGE_MAX_V);
					case DISCHARGE_MAX_CURRENT:
						return new IntegerReadChannel(s, channelId, SoltaroRackVersionB.DISCHARGE_MAX_A);
					case DISCHARGE_MIN_VOLTAGE:
						return new IntegerReadChannel(s, channelId, SoltaroRackVersionB.DISCHARGE_MIN_V);
					case READY_FOR_WORKING:
						return new BooleanReadChannel(s, channelId);
					case CAPACITY:
						return new IntegerReadChannel(s, channelId, SoltaroRackVersionB.CAPACITY_KWH);
					}
					return null;
				}), Arrays.stream(VersionBChannelId.values()).map(channelId -> {
					switch (channelId) {
					case BMS_CONTACTOR_CONTROL:
					case CELL_VOLTAGE_PROTECT:
					case CELL_VOLTAGE_RECOVER:
					case EMS_COMMUNICATION_TIMEOUT:
					case WORK_PARAMETER_PCS_COMMUNICATION_RATE:
					case AUTO_SET_SLAVES_ID:
					case AUTO_SET_SLAVES_TEMPERATURE_ID:
					case SYSTEM_RESET:
						
					case STOP_PARAMETER_CELL_OVER_TEMPERATURE_PROTECTION:
					case STOP_PARAMETER_CELL_OVER_TEMPERATURE_RECOVER:
					case STOP_PARAMETER_CELL_OVER_VOLTAGE_PROTECTION:
					case STOP_PARAMETER_CELL_OVER_VOLTAGE_RECOVER:
					case STOP_PARAMETER_CELL_UNDER_TEMPERATURE_PROTECTION:
					case STOP_PARAMETER_CELL_UNDER_TEMPERATURE_RECOVER:
					case STOP_PARAMETER_CELL_UNDER_VOLTAGE_PROTECTION:
					case STOP_PARAMETER_CELL_UNDER_VOLTAGE_RECOVER:
					case STOP_PARAMETER_CELL_VOLTAGE_DIFFERENCE_PROTECTION:
					case STOP_PARAMETER_CELL_VOLTAGE_DIFFERENCE_PROTECTION_RECOVER:
					case STOP_PARAMETER_CONNECTOR_TEMPERATURE_HIGH_PROTECTION:
					case STOP_PARAMETER_CONNECTOR_TEMPERATURE_HIGH_PROTECTION_RECOVER:
					case STOP_PARAMETER_DISCHARGE_TEMPERATURE_HIGH_PROTECTION:
					case STOP_PARAMETER_DISCHARGE_TEMPERATURE_HIGH_PROTECTION_RECOVER:
					case STOP_PARAMETER_DISCHARGE_TEMPERATURE_LOW_PROTECTION:
					case STOP_PARAMETER_DISCHARGE_TEMPERATURE_LOW_PROTECTION_RECOVER:
					case STOP_PARAMETER_INSULATION_PROTECTION:
					case STOP_PARAMETER_INSULATION_PROTECTION_RECOVER:
					case STOP_PARAMETER_SOC_HIGH_PROTECTION:
					case STOP_PARAMETER_SOC_HIGH_PROTECTION_RECOVER:
					case STOP_PARAMETER_SOC_LOW_PROTECTION:
					case STOP_PARAMETER_SOC_LOW_PROTECTION_RECOVER:
					case STOP_PARAMETER_SYSTEM_CHARGE_OVER_CURRENT_PROTECTION:
					case STOP_PARAMETER_SYSTEM_CHARGE_OVER_CURRENT_RECOVER:
					case STOP_PARAMETER_SYSTEM_DISCHARGE_OVER_CURRENT_PROTECTION:
					case STOP_PARAMETER_SYSTEM_DISCHARGE_OVER_CURRENT_RECOVER:
					case STOP_PARAMETER_SYSTEM_OVER_VOLTAGE_PROTECTION:
					case STOP_PARAMETER_SYSTEM_OVER_VOLTAGE_RECOVER:
					case STOP_PARAMETER_SYSTEM_UNDER_VOLTAGE_PROTECTION:
					case STOP_PARAMETER_SYSTEM_UNDER_VOLTAGE_RECOVER:
					case STOP_PARAMETER_TEMPERATURE_DIFFERENCE_PROTECTION:
					case STOP_PARAMETER_TEMPERATURE_DIFFERENCE_PROTECTION_RECOVER:
					case STOP_PARAMETER_TOTAL_VOLTAGE_DIFFERENCE_PROTECTION:
					case STOP_PARAMETER_TOTAL_VOLTAGE_DIFFERENCE_PROTECTION_RECOVER:
						
					case WARN_PARAMETER_SOC_HIGH_ALARM_RECOVER:
					case WARN_PARAMETER_CELL_OVER_TEMPERATURE_ALARM:
					case WARN_PARAMETER_CELL_OVER_TEMPERATURE_RECOVER:
					case WARN_PARAMETER_CELL_OVER_VOLTAGE_ALARM:
					case WARN_PARAMETER_CELL_OVER_VOLTAGE_RECOVER:
					case WARN_PARAMETER_CELL_UNDER_TEMPERATURE_ALARM:
					case WARN_PARAMETER_CELL_UNDER_TEMPERATURE_RECOVER:
					case WARN_PARAMETER_CELL_UNDER_VOLTAGE_ALARM:
					case WARN_PARAMETER_CELL_UNDER_VOLTAGE_RECOVER:
					case WARN_PARAMETER_CELL_VOLTAGE_DIFFERENCE_ALARM:
					case WARN_PARAMETER_CELL_VOLTAGE_DIFFERENCE_ALARM_RECOVER:
					case WARN_PARAMETER_CONNECTOR_TEMPERATURE_HIGH_ALARM:
					case WARN_PARAMETER_CONNECTOR_TEMPERATURE_HIGH_ALARM_RECOVER:
					case WARN_PARAMETER_DISCHARGE_TEMPERATURE_HIGH_ALARM:
					case WARN_PARAMETER_DISCHARGE_TEMPERATURE_HIGH_ALARM_RECOVER:
					case WARN_PARAMETER_DISCHARGE_TEMPERATURE_LOW_ALARM:
					case WARN_PARAMETER_DISCHARGE_TEMPERATURE_LOW_ALARM_RECOVER:
					case WARN_PARAMETER_INSULATION_ALARM:
					case WARN_PARAMETER_INSULATION_ALARM_RECOVER:
					case WARN_PARAMETER_SOC_HIGH_ALARM:
					case WARN_PARAMETER_SOC_LOW_ALARM:
					case WARN_PARAMETER_SOC_LOW_ALARM_RECOVER:
					case WARN_PARAMETER_SYSTEM_CHARGE_OVER_CURRENT_ALARM:
					case WARN_PARAMETER_SYSTEM_CHARGE_OVER_CURRENT_RECOVER:
					case WARN_PARAMETER_SYSTEM_DISCHARGE_OVER_CURRENT_ALARM:
					case WARN_PARAMETER_SYSTEM_DISCHARGE_OVER_CURRENT_RECOVER:
					case WARN_PARAMETER_SYSTEM_OVER_VOLTAGE_ALARM:
					case WARN_PARAMETER_SYSTEM_OVER_VOLTAGE_RECOVER:
					case WARN_PARAMETER_SYSTEM_UNDER_VOLTAGE_ALARM:
					case WARN_PARAMETER_SYSTEM_UNDER_VOLTAGE_RECOVER:
					case WARN_PARAMETER_TEMPERATURE_DIFFERENCE_ALARM:
					case WARN_PARAMETER_TEMPERATURE_DIFFERENCE_ALARM_RECOVER:
					case WARN_PARAMETER_TOTAL_VOLTAGE_DIFFERENCE_ALARM:
					case WARN_PARAMETER_TOTAL_VOLTAGE_DIFFERENCE_ALARM_RECOVER:
						return new IntegerWriteChannel(s, channelId);

					case ALARM_LEVEL_1_CELL_CHA_TEMP_HIGH:
					case ALARM_LEVEL_1_CELL_CHA_TEMP_LOW:
					case ALARM_LEVEL_1_CELL_DISCHA_TEMP_HIGH:
					case ALARM_LEVEL_1_CELL_DISCHA_TEMP_LOW:
					case ALARM_LEVEL_1_CELL_TEMP_DIFF_HIGH:
					case ALARM_LEVEL_1_CELL_VOLTAGE_DIFF_HIGH:
					case ALARM_LEVEL_1_CELL_VOLTAGE_HIGH:
					case ALARM_LEVEL_1_CELL_VOLTAGE_LOW:
					case ALARM_LEVEL_1_CHA_CURRENT_HIGH:
					case ALARM_LEVEL_1_DISCHA_CURRENT_HIGH:
					case ALARM_LEVEL_1_INSULATION_LOW:
					case ALARM_LEVEL_1_SOC_LOW:
					case ALARM_LEVEL_1_TOTAL_VOLTAGE_DIFF_HIGH:
					case ALARM_LEVEL_1_TOTAL_VOLTAGE_HIGH:
					case ALARM_LEVEL_1_TOTAL_VOLTAGE_LOW:
					case ALARM_LEVEL_1_POLE_TEMPERATURE_TOO_HIGH:
					
					case ALARM_LEVEL_2_CELL_VOLTAGE_DIFFERENCE_HIGH:
					case ALARM_LEVEL_2_POLES_TEMPERATURE_DIFFERENCE_HIGH:
					case ALARM_LEVEL_2_SOC_LOW:
					case ALARM_LEVEL_2_TEMPERATURE_DIFFERENCE_HIGH:
					case ALARM_LEVEL_2_TOTAL_VOLTAGE_DIFFERENCE_HIGH:
					case ALARM_LEVEL_2_CELL_CHA_TEMP_HIGH:
					case ALARM_LEVEL_2_CELL_CHA_TEMP_LOW:
					case ALARM_LEVEL_2_CELL_DISCHA_TEMP_HIGH:
					case ALARM_LEVEL_2_CELL_DISCHA_TEMP_LOW:
					case ALARM_LEVEL_2_CELL_VOLTAGE_HIGH:
					case ALARM_LEVEL_2_CELL_VOLTAGE_LOW:
					case ALARM_LEVEL_2_CHA_CURRENT_HIGH:
					case ALARM_LEVEL_2_DISCHA_CURRENT_HIGH:
					case ALARM_LEVEL_2_INSULATION_LOW:
					case ALARM_LEVEL_2_TOTAL_VOLTAGE_HIGH:
					case ALARM_LEVEL_2_TOTAL_VOLTAGE_LOW:

					case FAILURE_BALANCING_MODULE:
					case FAILURE_CONNECTOR_WIRE:
					case FAILURE_EEPROM:
					case FAILURE_INITIALIZATION:
					case FAILURE_INTRANET_COMMUNICATION:
					case FAILURE_LTC6803:
					case FAILURE_SAMPLING_WIRE:
					case FAILURE_TEMP_SAMPLING:
					case FAILURE_TEMP_SAMPLING_LINE:
					case FAILURE_TEMP_SENSOR:
					case FAILURE_VOLTAGE_SAMPLING:
					case FAILURE_GR_T:
					case FAILURE_PCB:

					case PRECHARGE_TAKING_TOO_LONG:
						
					case ALARM_FLAG_STATUS_CELL_LOW_TEMPERATURE:
					case ALARM_FLAG_STATUS_CELL_LOW_VOLTAGE:
					case ALARM_FLAG_STATUS_CELL_OVER_TEMPERATURE:
					case ALARM_FLAG_STATUS_CELL_OVER_VOLTAGE:
					case ALARM_FLAG_STATUS_CELL_VOLTAGE_DIFFERENCE:
					case ALARM_FLAG_STATUS_CHARGE_OVER_CURRENT:
					case ALARM_FLAG_STATUS_DISCHARGE_OVER_CURRENT:
					case ALARM_FLAG_STATUS_DISCHARGE_TEMPERATURE_HIGH:
					case ALARM_FLAG_STATUS_DISCHARGE_TEMPERATURE_LOW:
					case ALARM_FLAG_STATUS_ELECTRODE_TEMPERATURE_HIGH:
					case ALARM_FLAG_STATUS_INSULATION_LOW:
					case ALARM_FLAG_STATUS_SOC_LOW:
					case ALARM_FLAG_STATUS_SYSTEM_LOW_VOLTAGE:
					case ALARM_FLAG_STATUS_SYSTEM_OVER_VOLTAGE:
					case ALARM_FLAG_STATUS_TEMPERATURE_DIFFERENCE:
					case ALARM_FLAG_STATUS_VOLTAGE_DIFFERENCE:
						
					case PROTECT_FLAG_STATUS_CELL_LOW_TEMPERATURE:
					case PROTECT_FLAG_STATUS_CELL_LOW_VOLTAGE:
					case PROTECT_FLAG_STATUS_CELL_OVER_TEMPERATURE:
					case PROTECT_FLAG_STATUS_CELL_OVER_VOLTAGE:
					case PROTECT_FLAG_STATUS_CELL_VOLTAGE_DIFFERENCE:
					case PROTECT_FLAG_STATUS_CHARGE_OVER_CURRENT:
					case PROTECT_FLAG_STATUS_DISCHARGE_OVER_CURRENT:
					case PROTECT_FLAG_STATUS_DISCHARGE_TEMPERATURE_HIGH:
					case PROTECT_FLAG_STATUS_DISCHARGE_TEMPERATURE_LOW:
					case PROTECT_FLAG_STATUS_ELECTRODE_TEMPERATURE_HIGH:
					case PROTECT_FLAG_STATUS_INSULATION_LOW:
					case PROTECT_FLAG_STATUS_SOC_LOW:
					case PROTECT_FLAG_STATUS_SYSTEM_LOW_VOLTAGE:
					case PROTECT_FLAG_STATUS_SYSTEM_OVER_VOLTAGE:
					case PROTECT_FLAG_STATUS_TEMPERATURE_DIFFERENCE:
					case PROTECT_FLAG_STATUS_VOLTAGE_DIFFERENCE:
						
					case SLAVE_1_COMMUNICATION_ERROR:
					case SLAVE_2_COMMUNICATION_ERROR:
					case SLAVE_3_COMMUNICATION_ERROR:
					case SLAVE_4_COMMUNICATION_ERROR:
					case SLAVE_5_COMMUNICATION_ERROR:
					case SLAVE_6_COMMUNICATION_ERROR:
					case SLAVE_7_COMMUNICATION_ERROR:
					case SLAVE_8_COMMUNICATION_ERROR:
					case SLAVE_9_COMMUNICATION_ERROR:
					case SLAVE_10_COMMUNICATION_ERROR:
					case SLAVE_11_COMMUNICATION_ERROR:
					case SLAVE_12_COMMUNICATION_ERROR:
					case SLAVE_13_COMMUNICATION_ERROR:
					case SLAVE_14_COMMUNICATION_ERROR:
					case SLAVE_15_COMMUNICATION_ERROR:
					case SLAVE_16_COMMUNICATION_ERROR:
					case SLAVE_17_COMMUNICATION_ERROR:
					case SLAVE_18_COMMUNICATION_ERROR:
					case SLAVE_19_COMMUNICATION_ERROR:
					case SLAVE_20_COMMUNICATION_ERROR:
						
						return new StateChannel(s, channelId);
						
					case CLUSTER_1_BATTERY_000_VOLTAGE:
					case CLUSTER_1_BATTERY_001_VOLTAGE:
					case CLUSTER_1_BATTERY_002_VOLTAGE:
					case CLUSTER_1_BATTERY_003_VOLTAGE:
					case CLUSTER_1_BATTERY_004_VOLTAGE:
					case CLUSTER_1_BATTERY_005_VOLTAGE:
					case CLUSTER_1_BATTERY_006_VOLTAGE:
					case CLUSTER_1_BATTERY_007_VOLTAGE:
					case CLUSTER_1_BATTERY_008_VOLTAGE:
					case CLUSTER_1_BATTERY_009_VOLTAGE:
					case CLUSTER_1_BATTERY_010_VOLTAGE:
					case CLUSTER_1_BATTERY_011_VOLTAGE:
					case CLUSTER_1_BATTERY_012_VOLTAGE:
					case CLUSTER_1_BATTERY_013_VOLTAGE:
					case CLUSTER_1_BATTERY_014_VOLTAGE:
					case CLUSTER_1_BATTERY_015_VOLTAGE:
					case CLUSTER_1_BATTERY_016_VOLTAGE:
					case CLUSTER_1_BATTERY_017_VOLTAGE:
					case CLUSTER_1_BATTERY_018_VOLTAGE:
					case CLUSTER_1_BATTERY_019_VOLTAGE:
					case CLUSTER_1_BATTERY_020_VOLTAGE:
					case CLUSTER_1_BATTERY_021_VOLTAGE:
					case CLUSTER_1_BATTERY_022_VOLTAGE:
					case CLUSTER_1_BATTERY_023_VOLTAGE:
					case CLUSTER_1_BATTERY_024_VOLTAGE:
					case CLUSTER_1_BATTERY_025_VOLTAGE:
					case CLUSTER_1_BATTERY_026_VOLTAGE:
					case CLUSTER_1_BATTERY_027_VOLTAGE:
					case CLUSTER_1_BATTERY_028_VOLTAGE:
					case CLUSTER_1_BATTERY_029_VOLTAGE:
					case CLUSTER_1_BATTERY_030_VOLTAGE:
					case CLUSTER_1_BATTERY_031_VOLTAGE:
					case CLUSTER_1_BATTERY_032_VOLTAGE:
					case CLUSTER_1_BATTERY_033_VOLTAGE:
					case CLUSTER_1_BATTERY_034_VOLTAGE:
					case CLUSTER_1_BATTERY_035_VOLTAGE:
					case CLUSTER_1_BATTERY_036_VOLTAGE:
					case CLUSTER_1_BATTERY_037_VOLTAGE:
					case CLUSTER_1_BATTERY_038_VOLTAGE:
					case CLUSTER_1_BATTERY_039_VOLTAGE:
					case CLUSTER_1_BATTERY_040_VOLTAGE:
					case CLUSTER_1_BATTERY_041_VOLTAGE:
					case CLUSTER_1_BATTERY_042_VOLTAGE:
					case CLUSTER_1_BATTERY_043_VOLTAGE:
					case CLUSTER_1_BATTERY_044_VOLTAGE:
					case CLUSTER_1_BATTERY_045_VOLTAGE:
					case CLUSTER_1_BATTERY_046_VOLTAGE:
					case CLUSTER_1_BATTERY_047_VOLTAGE:
					case CLUSTER_1_BATTERY_048_VOLTAGE:
					case CLUSTER_1_BATTERY_049_VOLTAGE:
					case CLUSTER_1_BATTERY_050_VOLTAGE:
					case CLUSTER_1_BATTERY_051_VOLTAGE:
					case CLUSTER_1_BATTERY_052_VOLTAGE:
					case CLUSTER_1_BATTERY_053_VOLTAGE:
					case CLUSTER_1_BATTERY_054_VOLTAGE:
					case CLUSTER_1_BATTERY_055_VOLTAGE:
					case CLUSTER_1_BATTERY_056_VOLTAGE:
					case CLUSTER_1_BATTERY_057_VOLTAGE:
					case CLUSTER_1_BATTERY_058_VOLTAGE:
					case CLUSTER_1_BATTERY_059_VOLTAGE:
					case CLUSTER_1_BATTERY_060_VOLTAGE:
					case CLUSTER_1_BATTERY_061_VOLTAGE:
					case CLUSTER_1_BATTERY_062_VOLTAGE:
					case CLUSTER_1_BATTERY_063_VOLTAGE:
					case CLUSTER_1_BATTERY_064_VOLTAGE:
					case CLUSTER_1_BATTERY_065_VOLTAGE:
					case CLUSTER_1_BATTERY_066_VOLTAGE:
					case CLUSTER_1_BATTERY_067_VOLTAGE:
					case CLUSTER_1_BATTERY_068_VOLTAGE:
					case CLUSTER_1_BATTERY_069_VOLTAGE:
					case CLUSTER_1_BATTERY_070_VOLTAGE:
					case CLUSTER_1_BATTERY_071_VOLTAGE:
					case CLUSTER_1_BATTERY_072_VOLTAGE:
					case CLUSTER_1_BATTERY_073_VOLTAGE:
					case CLUSTER_1_BATTERY_074_VOLTAGE:
					case CLUSTER_1_BATTERY_075_VOLTAGE:
					case CLUSTER_1_BATTERY_076_VOLTAGE:
					case CLUSTER_1_BATTERY_077_VOLTAGE:
					case CLUSTER_1_BATTERY_078_VOLTAGE:
					case CLUSTER_1_BATTERY_079_VOLTAGE:
					case CLUSTER_1_BATTERY_080_VOLTAGE:
					case CLUSTER_1_BATTERY_081_VOLTAGE:
					case CLUSTER_1_BATTERY_082_VOLTAGE:
					case CLUSTER_1_BATTERY_083_VOLTAGE:
					case CLUSTER_1_BATTERY_084_VOLTAGE:
					case CLUSTER_1_BATTERY_085_VOLTAGE:
					case CLUSTER_1_BATTERY_086_VOLTAGE:
					case CLUSTER_1_BATTERY_087_VOLTAGE:
					case CLUSTER_1_BATTERY_088_VOLTAGE:
					case CLUSTER_1_BATTERY_089_VOLTAGE:
					case CLUSTER_1_BATTERY_090_VOLTAGE:
					case CLUSTER_1_BATTERY_091_VOLTAGE:
					case CLUSTER_1_BATTERY_092_VOLTAGE:
					case CLUSTER_1_BATTERY_093_VOLTAGE:
					case CLUSTER_1_BATTERY_094_VOLTAGE:
					case CLUSTER_1_BATTERY_095_VOLTAGE:
					case CLUSTER_1_BATTERY_096_VOLTAGE:
					case CLUSTER_1_BATTERY_097_VOLTAGE:
					case CLUSTER_1_BATTERY_098_VOLTAGE:
					case CLUSTER_1_BATTERY_099_VOLTAGE:
					case CLUSTER_1_BATTERY_100_VOLTAGE:
					case CLUSTER_1_BATTERY_101_VOLTAGE:
					case CLUSTER_1_BATTERY_102_VOLTAGE:
					case CLUSTER_1_BATTERY_103_VOLTAGE:
					case CLUSTER_1_BATTERY_104_VOLTAGE:
					case CLUSTER_1_BATTERY_105_VOLTAGE:
					case CLUSTER_1_BATTERY_106_VOLTAGE:
					case CLUSTER_1_BATTERY_107_VOLTAGE:
					case CLUSTER_1_BATTERY_108_VOLTAGE:
					case CLUSTER_1_BATTERY_109_VOLTAGE:
					case CLUSTER_1_BATTERY_110_VOLTAGE:
					case CLUSTER_1_BATTERY_111_VOLTAGE:
					case CLUSTER_1_BATTERY_112_VOLTAGE:
					case CLUSTER_1_BATTERY_113_VOLTAGE:
					case CLUSTER_1_BATTERY_114_VOLTAGE:
					case CLUSTER_1_BATTERY_115_VOLTAGE:
					case CLUSTER_1_BATTERY_116_VOLTAGE:
					case CLUSTER_1_BATTERY_117_VOLTAGE:
					case CLUSTER_1_BATTERY_118_VOLTAGE:
					case CLUSTER_1_BATTERY_119_VOLTAGE:
					case CLUSTER_1_BATTERY_120_VOLTAGE:
					case CLUSTER_1_BATTERY_121_VOLTAGE:
					case CLUSTER_1_BATTERY_122_VOLTAGE:
					case CLUSTER_1_BATTERY_123_VOLTAGE:
					case CLUSTER_1_BATTERY_124_VOLTAGE:
					case CLUSTER_1_BATTERY_125_VOLTAGE:
					case CLUSTER_1_BATTERY_126_VOLTAGE:
					case CLUSTER_1_BATTERY_127_VOLTAGE:
					case CLUSTER_1_BATTERY_128_VOLTAGE:
					case CLUSTER_1_BATTERY_129_VOLTAGE:
					case CLUSTER_1_BATTERY_130_VOLTAGE:
					case CLUSTER_1_BATTERY_131_VOLTAGE:
					case CLUSTER_1_BATTERY_132_VOLTAGE:
					case CLUSTER_1_BATTERY_133_VOLTAGE:
					case CLUSTER_1_BATTERY_134_VOLTAGE:
					case CLUSTER_1_BATTERY_135_VOLTAGE:
					case CLUSTER_1_BATTERY_136_VOLTAGE:
					case CLUSTER_1_BATTERY_137_VOLTAGE:
					case CLUSTER_1_BATTERY_138_VOLTAGE:
					case CLUSTER_1_BATTERY_139_VOLTAGE:
					case CLUSTER_1_BATTERY_140_VOLTAGE:
					case CLUSTER_1_BATTERY_141_VOLTAGE:
					case CLUSTER_1_BATTERY_142_VOLTAGE:
					case CLUSTER_1_BATTERY_143_VOLTAGE:
					case CLUSTER_1_BATTERY_144_VOLTAGE:
					case CLUSTER_1_BATTERY_145_VOLTAGE:
					case CLUSTER_1_BATTERY_146_VOLTAGE:
					case CLUSTER_1_BATTERY_147_VOLTAGE:
					case CLUSTER_1_BATTERY_148_VOLTAGE:
					case CLUSTER_1_BATTERY_149_VOLTAGE:
					case CLUSTER_1_BATTERY_150_VOLTAGE:
					case CLUSTER_1_BATTERY_151_VOLTAGE:
					case CLUSTER_1_BATTERY_152_VOLTAGE:
					case CLUSTER_1_BATTERY_153_VOLTAGE:
					case CLUSTER_1_BATTERY_154_VOLTAGE:
					case CLUSTER_1_BATTERY_155_VOLTAGE:
					case CLUSTER_1_BATTERY_156_VOLTAGE:
					case CLUSTER_1_BATTERY_157_VOLTAGE:
					case CLUSTER_1_BATTERY_158_VOLTAGE:
					case CLUSTER_1_BATTERY_159_VOLTAGE:
					case CLUSTER_1_BATTERY_160_VOLTAGE:
					case CLUSTER_1_BATTERY_161_VOLTAGE:
					case CLUSTER_1_BATTERY_162_VOLTAGE:
					case CLUSTER_1_BATTERY_163_VOLTAGE:
					case CLUSTER_1_BATTERY_164_VOLTAGE:
					case CLUSTER_1_BATTERY_165_VOLTAGE:
					case CLUSTER_1_BATTERY_166_VOLTAGE:
					case CLUSTER_1_BATTERY_167_VOLTAGE:
					case CLUSTER_1_BATTERY_168_VOLTAGE:
					case CLUSTER_1_BATTERY_169_VOLTAGE:
					case CLUSTER_1_BATTERY_170_VOLTAGE:
					case CLUSTER_1_BATTERY_171_VOLTAGE:
					case CLUSTER_1_BATTERY_172_VOLTAGE:
					case CLUSTER_1_BATTERY_173_VOLTAGE:
					case CLUSTER_1_BATTERY_174_VOLTAGE:
					case CLUSTER_1_BATTERY_175_VOLTAGE:
					case CLUSTER_1_BATTERY_176_VOLTAGE:
					case CLUSTER_1_BATTERY_177_VOLTAGE:
					case CLUSTER_1_BATTERY_178_VOLTAGE:
					case CLUSTER_1_BATTERY_179_VOLTAGE:
					case CLUSTER_1_BATTERY_180_VOLTAGE:
					case CLUSTER_1_BATTERY_181_VOLTAGE:
					case CLUSTER_1_BATTERY_182_VOLTAGE:
					case CLUSTER_1_BATTERY_183_VOLTAGE:
					case CLUSTER_1_BATTERY_184_VOLTAGE:
					case CLUSTER_1_BATTERY_185_VOLTAGE:
					case CLUSTER_1_BATTERY_186_VOLTAGE:
					case CLUSTER_1_BATTERY_187_VOLTAGE:
					case CLUSTER_1_BATTERY_188_VOLTAGE:
					case CLUSTER_1_BATTERY_189_VOLTAGE:
					case CLUSTER_1_BATTERY_190_VOLTAGE:
					case CLUSTER_1_BATTERY_191_VOLTAGE:
					case CLUSTER_1_BATTERY_192_VOLTAGE:
					case CLUSTER_1_BATTERY_193_VOLTAGE:
					case CLUSTER_1_BATTERY_194_VOLTAGE:
					case CLUSTER_1_BATTERY_195_VOLTAGE:
					case CLUSTER_1_BATTERY_196_VOLTAGE:
					case CLUSTER_1_BATTERY_197_VOLTAGE:
					case CLUSTER_1_BATTERY_198_VOLTAGE:
					case CLUSTER_1_BATTERY_199_VOLTAGE:
					case CLUSTER_1_BATTERY_200_VOLTAGE:
					case CLUSTER_1_BATTERY_201_VOLTAGE:
					case CLUSTER_1_BATTERY_202_VOLTAGE:
					case CLUSTER_1_BATTERY_203_VOLTAGE:
					case CLUSTER_1_BATTERY_204_VOLTAGE:
					case CLUSTER_1_BATTERY_205_VOLTAGE:
					case CLUSTER_1_BATTERY_206_VOLTAGE:
					case CLUSTER_1_BATTERY_207_VOLTAGE:
					case CLUSTER_1_BATTERY_208_VOLTAGE:
					case CLUSTER_1_BATTERY_209_VOLTAGE:
					case CLUSTER_1_BATTERY_210_VOLTAGE:
					case CLUSTER_1_BATTERY_211_VOLTAGE:
					case CLUSTER_1_BATTERY_212_VOLTAGE:
					case CLUSTER_1_BATTERY_213_VOLTAGE:
					case CLUSTER_1_BATTERY_214_VOLTAGE:
					case CLUSTER_1_BATTERY_215_VOLTAGE:
					case CLUSTER_1_BATTERY_216_VOLTAGE:
					case CLUSTER_1_BATTERY_217_VOLTAGE:
					case CLUSTER_1_BATTERY_218_VOLTAGE:
					case CLUSTER_1_BATTERY_219_VOLTAGE:
					case CLUSTER_1_BATTERY_220_VOLTAGE:
					case CLUSTER_1_BATTERY_221_VOLTAGE:
					case CLUSTER_1_BATTERY_222_VOLTAGE:
					case CLUSTER_1_BATTERY_223_VOLTAGE:
					case CLUSTER_1_BATTERY_224_VOLTAGE:
					case CLUSTER_1_BATTERY_225_VOLTAGE:
					case CLUSTER_1_BATTERY_226_VOLTAGE:
					case CLUSTER_1_BATTERY_227_VOLTAGE:
					case CLUSTER_1_BATTERY_228_VOLTAGE:
					case CLUSTER_1_BATTERY_229_VOLTAGE:
					case CLUSTER_1_BATTERY_230_VOLTAGE:
					case CLUSTER_1_BATTERY_231_VOLTAGE:
					case CLUSTER_1_BATTERY_232_VOLTAGE:
					case CLUSTER_1_BATTERY_233_VOLTAGE:
					case CLUSTER_1_BATTERY_234_VOLTAGE:
					case CLUSTER_1_BATTERY_235_VOLTAGE:
					case CLUSTER_1_BATTERY_236_VOLTAGE:
					case CLUSTER_1_BATTERY_237_VOLTAGE:
					case CLUSTER_1_BATTERY_238_VOLTAGE:
					case CLUSTER_1_BATTERY_239_VOLTAGE:

					case CLUSTER_1_BATTERY_000_TEMPERATURE:
					case CLUSTER_1_BATTERY_001_TEMPERATURE:
					case CLUSTER_1_BATTERY_002_TEMPERATURE:
					case CLUSTER_1_BATTERY_003_TEMPERATURE:
					case CLUSTER_1_BATTERY_004_TEMPERATURE:
					case CLUSTER_1_BATTERY_005_TEMPERATURE:
					case CLUSTER_1_BATTERY_006_TEMPERATURE:
					case CLUSTER_1_BATTERY_007_TEMPERATURE:
					case CLUSTER_1_BATTERY_008_TEMPERATURE:
					case CLUSTER_1_BATTERY_009_TEMPERATURE:
					case CLUSTER_1_BATTERY_010_TEMPERATURE:
					case CLUSTER_1_BATTERY_011_TEMPERATURE:
					case CLUSTER_1_BATTERY_012_TEMPERATURE:
					case CLUSTER_1_BATTERY_013_TEMPERATURE:
					case CLUSTER_1_BATTERY_014_TEMPERATURE:
					case CLUSTER_1_BATTERY_015_TEMPERATURE:
					case CLUSTER_1_BATTERY_016_TEMPERATURE:
					case CLUSTER_1_BATTERY_017_TEMPERATURE:
					case CLUSTER_1_BATTERY_018_TEMPERATURE:
					case CLUSTER_1_BATTERY_019_TEMPERATURE:
					case CLUSTER_1_BATTERY_020_TEMPERATURE:
					case CLUSTER_1_BATTERY_021_TEMPERATURE:
					case CLUSTER_1_BATTERY_022_TEMPERATURE:
					case CLUSTER_1_BATTERY_023_TEMPERATURE:
					case CLUSTER_1_BATTERY_024_TEMPERATURE:
					case CLUSTER_1_BATTERY_025_TEMPERATURE:
					case CLUSTER_1_BATTERY_026_TEMPERATURE:
					case CLUSTER_1_BATTERY_027_TEMPERATURE:
					case CLUSTER_1_BATTERY_028_TEMPERATURE:
					case CLUSTER_1_BATTERY_029_TEMPERATURE:
					case CLUSTER_1_BATTERY_030_TEMPERATURE:
					case CLUSTER_1_BATTERY_031_TEMPERATURE:
					case CLUSTER_1_BATTERY_032_TEMPERATURE:
					case CLUSTER_1_BATTERY_033_TEMPERATURE:
					case CLUSTER_1_BATTERY_034_TEMPERATURE:
					case CLUSTER_1_BATTERY_035_TEMPERATURE:
					case CLUSTER_1_BATTERY_036_TEMPERATURE:
					case CLUSTER_1_BATTERY_037_TEMPERATURE:
					case CLUSTER_1_BATTERY_038_TEMPERATURE:
					case CLUSTER_1_BATTERY_039_TEMPERATURE:
					case CLUSTER_1_BATTERY_040_TEMPERATURE:
					case CLUSTER_1_BATTERY_041_TEMPERATURE:
					case CLUSTER_1_BATTERY_042_TEMPERATURE:
					case CLUSTER_1_BATTERY_043_TEMPERATURE:
					case CLUSTER_1_BATTERY_044_TEMPERATURE:
					case CLUSTER_1_BATTERY_045_TEMPERATURE:
					case CLUSTER_1_BATTERY_046_TEMPERATURE:
					case CLUSTER_1_BATTERY_047_TEMPERATURE:
					case CLUSTER_1_BATTERY_048_TEMPERATURE:
					case CLUSTER_1_BATTERY_049_TEMPERATURE:
					case CLUSTER_1_BATTERY_050_TEMPERATURE:
					case CLUSTER_1_BATTERY_051_TEMPERATURE:
					case CLUSTER_1_BATTERY_052_TEMPERATURE:
					case CLUSTER_1_BATTERY_053_TEMPERATURE:
					case CLUSTER_1_BATTERY_054_TEMPERATURE:
					case CLUSTER_1_BATTERY_055_TEMPERATURE:
					case CLUSTER_1_BATTERY_056_TEMPERATURE:
					case CLUSTER_1_BATTERY_057_TEMPERATURE:
					case CLUSTER_1_BATTERY_058_TEMPERATURE:
					case CLUSTER_1_BATTERY_059_TEMPERATURE:
					case CLUSTER_1_BATTERY_060_TEMPERATURE:
					case CLUSTER_1_BATTERY_061_TEMPERATURE:
					case CLUSTER_1_BATTERY_062_TEMPERATURE:
					case CLUSTER_1_BATTERY_063_TEMPERATURE:
					case CLUSTER_1_BATTERY_064_TEMPERATURE:
					case CLUSTER_1_BATTERY_065_TEMPERATURE:
					case CLUSTER_1_BATTERY_066_TEMPERATURE:
					case CLUSTER_1_BATTERY_067_TEMPERATURE:
					case CLUSTER_1_BATTERY_068_TEMPERATURE:
					case CLUSTER_1_BATTERY_069_TEMPERATURE:
					case CLUSTER_1_BATTERY_070_TEMPERATURE:
					case CLUSTER_1_BATTERY_071_TEMPERATURE:
					case CLUSTER_1_BATTERY_072_TEMPERATURE:
					case CLUSTER_1_BATTERY_073_TEMPERATURE:
					case CLUSTER_1_BATTERY_074_TEMPERATURE:
					case CLUSTER_1_BATTERY_075_TEMPERATURE:
					case CLUSTER_1_BATTERY_076_TEMPERATURE:
					case CLUSTER_1_BATTERY_077_TEMPERATURE:
					case CLUSTER_1_BATTERY_078_TEMPERATURE:
					case CLUSTER_1_BATTERY_079_TEMPERATURE:
					case CLUSTER_1_BATTERY_080_TEMPERATURE:
					case CLUSTER_1_BATTERY_081_TEMPERATURE:
					case CLUSTER_1_BATTERY_082_TEMPERATURE:
					case CLUSTER_1_BATTERY_083_TEMPERATURE:
					case CLUSTER_1_BATTERY_084_TEMPERATURE:
					case CLUSTER_1_BATTERY_085_TEMPERATURE:
					case CLUSTER_1_BATTERY_086_TEMPERATURE:
					case CLUSTER_1_BATTERY_087_TEMPERATURE:
					case CLUSTER_1_BATTERY_088_TEMPERATURE:
					case CLUSTER_1_BATTERY_089_TEMPERATURE:
					case CLUSTER_1_BATTERY_090_TEMPERATURE:
					case CLUSTER_1_BATTERY_091_TEMPERATURE:
					case CLUSTER_1_BATTERY_092_TEMPERATURE:
					case CLUSTER_1_BATTERY_093_TEMPERATURE:
					case CLUSTER_1_BATTERY_094_TEMPERATURE:
					case CLUSTER_1_BATTERY_095_TEMPERATURE:
					case CLUSTER_1_BATTERY_096_TEMPERATURE:
					case CLUSTER_1_BATTERY_097_TEMPERATURE:
					case CLUSTER_1_BATTERY_098_TEMPERATURE:
					case CLUSTER_1_BATTERY_099_TEMPERATURE:
					case CLUSTER_1_BATTERY_100_TEMPERATURE:
					case CLUSTER_1_BATTERY_101_TEMPERATURE:
					case CLUSTER_1_BATTERY_102_TEMPERATURE:
					case CLUSTER_1_BATTERY_103_TEMPERATURE:
					case CLUSTER_1_BATTERY_104_TEMPERATURE:
					case CLUSTER_1_BATTERY_105_TEMPERATURE:
					case CLUSTER_1_BATTERY_106_TEMPERATURE:
					case CLUSTER_1_BATTERY_107_TEMPERATURE:
					case CLUSTER_1_BATTERY_108_TEMPERATURE:
					case CLUSTER_1_BATTERY_109_TEMPERATURE:
					case CLUSTER_1_BATTERY_110_TEMPERATURE:
					case CLUSTER_1_BATTERY_111_TEMPERATURE:
					case CLUSTER_1_BATTERY_112_TEMPERATURE:
					case CLUSTER_1_BATTERY_113_TEMPERATURE:
					case CLUSTER_1_BATTERY_114_TEMPERATURE:
					case CLUSTER_1_BATTERY_115_TEMPERATURE:
					case CLUSTER_1_BATTERY_116_TEMPERATURE:
					case CLUSTER_1_BATTERY_117_TEMPERATURE:
					case CLUSTER_1_BATTERY_118_TEMPERATURE:
					case CLUSTER_1_BATTERY_119_TEMPERATURE:
					case CLUSTER_1_BATTERY_120_TEMPERATURE:
					case CLUSTER_1_BATTERY_121_TEMPERATURE:
					case CLUSTER_1_BATTERY_122_TEMPERATURE:
					case CLUSTER_1_BATTERY_123_TEMPERATURE:
					case CLUSTER_1_BATTERY_124_TEMPERATURE:
					case CLUSTER_1_BATTERY_125_TEMPERATURE:
					case CLUSTER_1_BATTERY_126_TEMPERATURE:
					case CLUSTER_1_BATTERY_127_TEMPERATURE:
					case CLUSTER_1_BATTERY_128_TEMPERATURE:
					case CLUSTER_1_BATTERY_129_TEMPERATURE:
					case CLUSTER_1_BATTERY_130_TEMPERATURE:
					case CLUSTER_1_BATTERY_131_TEMPERATURE:
					case CLUSTER_1_BATTERY_132_TEMPERATURE:
					case CLUSTER_1_BATTERY_133_TEMPERATURE:
					case CLUSTER_1_BATTERY_134_TEMPERATURE:
					case CLUSTER_1_BATTERY_135_TEMPERATURE:
					case CLUSTER_1_BATTERY_136_TEMPERATURE:
					case CLUSTER_1_BATTERY_137_TEMPERATURE:
					case CLUSTER_1_BATTERY_138_TEMPERATURE:
					case CLUSTER_1_BATTERY_139_TEMPERATURE:
					case CLUSTER_1_BATTERY_140_TEMPERATURE:
					case CLUSTER_1_BATTERY_141_TEMPERATURE:
					case CLUSTER_1_BATTERY_142_TEMPERATURE:
					case CLUSTER_1_BATTERY_143_TEMPERATURE:
					case CLUSTER_1_BATTERY_144_TEMPERATURE:
					case CLUSTER_1_BATTERY_145_TEMPERATURE:
					case CLUSTER_1_BATTERY_146_TEMPERATURE:
					case CLUSTER_1_BATTERY_147_TEMPERATURE:
					case CLUSTER_1_BATTERY_148_TEMPERATURE:
					case CLUSTER_1_BATTERY_149_TEMPERATURE:
					case CLUSTER_1_BATTERY_150_TEMPERATURE:
					case CLUSTER_1_BATTERY_151_TEMPERATURE:
					case CLUSTER_1_BATTERY_152_TEMPERATURE:
					case CLUSTER_1_BATTERY_153_TEMPERATURE:
					case CLUSTER_1_BATTERY_154_TEMPERATURE:
					case CLUSTER_1_BATTERY_155_TEMPERATURE:
					case CLUSTER_1_BATTERY_156_TEMPERATURE:
					case CLUSTER_1_BATTERY_157_TEMPERATURE:
					case CLUSTER_1_BATTERY_158_TEMPERATURE:
					case CLUSTER_1_BATTERY_159_TEMPERATURE:
					case CLUSTER_1_BATTERY_160_TEMPERATURE:
					case CLUSTER_1_BATTERY_161_TEMPERATURE:
					case CLUSTER_1_BATTERY_162_TEMPERATURE:
					case CLUSTER_1_BATTERY_163_TEMPERATURE:
					case CLUSTER_1_BATTERY_164_TEMPERATURE:
					case CLUSTER_1_BATTERY_165_TEMPERATURE:
					case CLUSTER_1_BATTERY_166_TEMPERATURE:
					case CLUSTER_1_BATTERY_167_TEMPERATURE:
					case CLUSTER_1_BATTERY_168_TEMPERATURE:
					case CLUSTER_1_BATTERY_169_TEMPERATURE:
					case CLUSTER_1_BATTERY_170_TEMPERATURE:
					case CLUSTER_1_BATTERY_171_TEMPERATURE:
					case CLUSTER_1_BATTERY_172_TEMPERATURE:
					case CLUSTER_1_BATTERY_173_TEMPERATURE:
					case CLUSTER_1_BATTERY_174_TEMPERATURE:
					case CLUSTER_1_BATTERY_175_TEMPERATURE:
					case CLUSTER_1_BATTERY_176_TEMPERATURE:
					case CLUSTER_1_BATTERY_177_TEMPERATURE:
					case CLUSTER_1_BATTERY_178_TEMPERATURE:
					case CLUSTER_1_BATTERY_179_TEMPERATURE:
					case CLUSTER_1_BATTERY_180_TEMPERATURE:
					case CLUSTER_1_BATTERY_181_TEMPERATURE:
					case CLUSTER_1_BATTERY_182_TEMPERATURE:
					case CLUSTER_1_BATTERY_183_TEMPERATURE:
					case CLUSTER_1_BATTERY_184_TEMPERATURE:
					case CLUSTER_1_BATTERY_185_TEMPERATURE:
					case CLUSTER_1_BATTERY_186_TEMPERATURE:
					case CLUSTER_1_BATTERY_187_TEMPERATURE:
					case CLUSTER_1_BATTERY_188_TEMPERATURE:
					case CLUSTER_1_BATTERY_189_TEMPERATURE:
					case CLUSTER_1_BATTERY_190_TEMPERATURE:
					case CLUSTER_1_BATTERY_191_TEMPERATURE:
					case CLUSTER_1_BATTERY_192_TEMPERATURE:
					case CLUSTER_1_BATTERY_193_TEMPERATURE:
					case CLUSTER_1_BATTERY_194_TEMPERATURE:
					case CLUSTER_1_BATTERY_195_TEMPERATURE:
					case CLUSTER_1_BATTERY_196_TEMPERATURE:
					case CLUSTER_1_BATTERY_197_TEMPERATURE:
					case CLUSTER_1_BATTERY_198_TEMPERATURE:
					case CLUSTER_1_BATTERY_199_TEMPERATURE:
					case CLUSTER_1_BATTERY_200_TEMPERATURE:
					case CLUSTER_1_BATTERY_201_TEMPERATURE:
					case CLUSTER_1_BATTERY_202_TEMPERATURE:
					case CLUSTER_1_BATTERY_203_TEMPERATURE:
					case CLUSTER_1_BATTERY_204_TEMPERATURE:
					case CLUSTER_1_BATTERY_205_TEMPERATURE:
					case CLUSTER_1_BATTERY_206_TEMPERATURE:
					case CLUSTER_1_BATTERY_207_TEMPERATURE:
					case CLUSTER_1_BATTERY_208_TEMPERATURE:
					case CLUSTER_1_BATTERY_209_TEMPERATURE:
					case CLUSTER_1_BATTERY_210_TEMPERATURE:
					case CLUSTER_1_BATTERY_211_TEMPERATURE:
					case CLUSTER_1_BATTERY_212_TEMPERATURE:
					case CLUSTER_1_BATTERY_213_TEMPERATURE:
					case CLUSTER_1_BATTERY_214_TEMPERATURE:
					case CLUSTER_1_BATTERY_215_TEMPERATURE:
					case CLUSTER_1_BATTERY_216_TEMPERATURE:
					case CLUSTER_1_BATTERY_217_TEMPERATURE:
					case CLUSTER_1_BATTERY_218_TEMPERATURE:
					case CLUSTER_1_BATTERY_219_TEMPERATURE:
					case CLUSTER_1_BATTERY_220_TEMPERATURE:
					case CLUSTER_1_BATTERY_221_TEMPERATURE:
					case CLUSTER_1_BATTERY_222_TEMPERATURE:
					case CLUSTER_1_BATTERY_223_TEMPERATURE:
					case CLUSTER_1_BATTERY_224_TEMPERATURE:
					case CLUSTER_1_BATTERY_225_TEMPERATURE:
					case CLUSTER_1_BATTERY_226_TEMPERATURE:
					case CLUSTER_1_BATTERY_227_TEMPERATURE:
					case CLUSTER_1_BATTERY_228_TEMPERATURE:
					case CLUSTER_1_BATTERY_229_TEMPERATURE:
					case CLUSTER_1_BATTERY_230_TEMPERATURE:
					case CLUSTER_1_BATTERY_231_TEMPERATURE:
					case CLUSTER_1_BATTERY_232_TEMPERATURE:
					case CLUSTER_1_BATTERY_233_TEMPERATURE:
					case CLUSTER_1_BATTERY_234_TEMPERATURE:
					case CLUSTER_1_BATTERY_235_TEMPERATURE:
					case CLUSTER_1_BATTERY_236_TEMPERATURE:
					case CLUSTER_1_BATTERY_237_TEMPERATURE:
					case CLUSTER_1_BATTERY_238_TEMPERATURE:
					case CLUSTER_1_BATTERY_239_TEMPERATURE:

					case CLUSTER_1_VOLTAGE:
					case CLUSTER_1_CURRENT:
					case CLUSTER_1_CHARGE_INDICATION:
					case CLUSTER_1_SOH:
					case CLUSTER_RUN_STATE:
					case SYSTEM_INSULATION:
					case SYSTEM_MAX_CHARGE_CURRENT:
					case SYSTEM_MAX_DISCHARGE_CURRENT:

					case CLUSTER_1_MIN_CELL_TEMPERATURE:
					case CLUSTER_1_MAX_CELL_TEMPERATURE:
					case CLUSTER_1_MAX_CELL_TEMPERATURE_ID:
					case CLUSTER_1_MAX_CELL_VOLTAGE:
					case CLUSTER_1_MAX_CELL_VOLTAGE_ID:
					case CLUSTER_1_MIN_CELL_TEMPERATURE_ID:
					case CLUSTER_1_MIN_CELL_VOLTAGE:
					case CLUSTER_1_MIN_CELL_VOLTAGE_ID:
						return new IntegerReadChannel(s, channelId);
					
						
						// ============== new values =================
						
					case ALARM_FLAG_REGISTER_1_CELL_OVER_VOLTAGE:
					case ALARM_FLAG_REGISTER_1_CELL_VOLTAGE_LOW:
										case ALARM_FLAG_REGISTER_1_CHARGE_OVER_CURRENT:
										case ALARM_FLAG_REGISTER_1_DISCHARGE_OVER_CURRENT:
										case ALARM_FLAG_REGISTER_1_SYSTEM_OVER_VOLTAGE:
										case ALARM_FLAG_REGISTER_1_SYSTEM_VOLTAGE_LOW:
										case ALARM_FLAG_REGISTER_1_TEMPERATURE_HIGH:
										case ALARM_FLAG_REGISTER_1_TEMPERATURE_LOW:
										case ALARM_FLAG_REGISTER_2_CELL_VOLTAGE_DIFFERENCE:
										case ALARM_FLAG_REGISTER_2_POLE_TEMPERATURE_HIGH:
										case ALARM_FLAG_REGISTER_2_POLE_TEMPERATURE_LOW:
										case ALARM_FLAG_REGISTER_2_SOC_HIGH:
										case ALARM_FLAG_REGISTER_2_SOC_LOW:
										
								
										
										case BATTERY_CHARGE_OVER_CURRENT_ALARM_TIMES:
										case BATTERY_CHARGE_OVER_CURRENT_STOP_TIMES:
										case BATTERY_DISCHARGE_OVER_CURRENT_ALARM_TIMES:
										case BATTERY_DISCHARGE_OVER_CURRENT_STOP_TIMES:
										case BATTERY_OVER_TEMPERATURE_ALARM_TIMES:
										case BATTERY_OVER_TEMPERATURE_STOP_TIMES:
										case BATTERY_OVER_VOLTAGE_ALARM_TIMES:
										case BATTERY_OVER_VOLTAGE_STOP_TIMES:
										case BATTERY_TEMPERATURE_LOW_ALARM_TIMES:
										case BATTERY_TEMPERATURE_LOW_STOP_TIMES:
										case BATTERY_VOLTAGE_DIFFERENCE_ALARM_TIMES:
										case BATTERY_VOLTAGE_DIFFERENCE_STOP_TIMES:
										case BATTERY_VOLTAGE_LOW_ALARM_TIMES:
										case BATTERY_VOLTAGE_LOW_STOP_TIMES:
										case CELL_OVER_VOLTAGE_ALARM_TIMES:
										case CELL_OVER_VOLTAGE_STOP_TIMES:
										case CELL_VOLTAGE_DIFFERENCE:
										case CELL_VOLTAGE_LOW_ALARM_TIMES:
										case CELL_VOLTAGE_LOW_STOP_TIMES:
										case CURRENT_BOX_SELF_CALIBRATION:
										case CYCLE_TIME:
										case DRY_CONTACT_1_EXPORT:
										case DRY_CONTACT_2_EXPORT:
										case ENVIRONMENT_TEMPERATURE:										
										case FAN_STATUS:
										case INSULATION_SENSOR_FUNCTION:
										case LAST_TIME_CHARGE_CAPACITY_LOW_BITS:
										case LAST_TIME_CHARGE_END_TIME_HIGH_BITS:
										case LAST_TIME_CHARGE_END_TIME_LOW_BITS:
										case LAST_TIME_DISCHARGE_CAPACITY_LOW_BITS:
										case LAST_TIME_DISCHARGE_END_TIME_HIGH_BITS:
										case LAST_TIME_DISCHARGE_END_TIME_LOW_BITS:
										case MAIN_CONTACTOR_FLAG:
										case MAIN_CONTACTOR_STATE:
										case MAXIMUM_CELL_VOLTAGE_NUMBER_WHEN_ALARM:
										case MAXIMUM_CELL_VOLTAGE_NUMBER_WHEN_STOPPED:
										case MAXIMUM_CELL_VOLTAGE_WHEN_ALARM:
										case MAXIMUM_CELL_VOLTAGE_WHEN_STOPPED:
										case MAX_CELL_RESISTANCE:
										case MAX_CELL_RESISTANCE_ID:
										case MINIMUM_CELL_VOLTAGE_NUMBER_WHEN_ALARM:
										case MINIMUM_CELL_VOLTAGE_NUMBER_WHEN_STOPPED:
										case MINIMUM_CELL_VOLTAGE_WHEN_ALARM:
										case MINIMUM_CELL_VOLTAGE_WHEN_STOPPED:
										case MIN_CELL_RESISTANCE:
										case MIN_CELL_RESISTANCE_ID:
										case NEGATIVE_INSULATION:
										case NUMBER_OF_TEMPERATURE_WHEN_ALARM:
										case OTHER_ALARM_EQUIPMENT_FAILURE:
										case OVER_CHARGE_CURRENT_WHEN_ALARM:
										case OVER_CHARGE_CURRENT_WHEN_STOPPED:
										case OVER_DISCHARGE_CURRENT_WHEN_ALARM:
										case OVER_DISCHARGE_CURRENT_WHEN_STOPPED:
										case OVER_VOLTAGE_VALUE_WHEN_ALARM:
										case OVER_VOLTAGE_VALUE_WHEN_STOPPED:
										case PCS_ALARM_RESET:
										case POSITIVE_INSULATION:
										case POWER_SUPPLY_VOLTAGE:
										case POWER_TEMPERATURE:
										case PRE_CONTACTOR_STATUS:
										case PROTECT_FLAG_REGISTER_1_CELL_OVER_VOLTAGE:
										case PROTECT_FLAG_REGISTER_1_CELL_VOLTAGE_LOW:
										case PROTECT_FLAG_REGISTER_1_CHARGE_OVER_CURRENT:
										case PROTECT_FLAG_REGISTER_1_DISCHARGE_OVER_CURRENT:
										case PROTECT_FLAG_REGISTER_1_SYSTEM_OVER_VOLTAGE:
										case PROTECT_FLAG_REGISTER_1_SYSTEM_VOLTAGE_LOW:
										case PROTECT_FLAG_REGISTER_1_TEMPERATURE_HIGH:
										case PROTECT_FLAG_REGISTER_1_TEMPERATURE_LOW:
										case PROTECT_FLAG_REGISTER_2_CELL_VOLTAGE_DIFFERENCE:
										case PROTECT_FLAG_REGISTER_2_POLE_TEMPERATURE_HIGH:
										case PROTECT_FLAG_REGISTER_2_POLE_TEMPERATURE_LOW:
										case PROTECT_FLAG_REGISTER_2_SOC_HIGH:
										case PROTECT_FLAG_REGISTER_2_SOC_LOW:
										
										case SET_EMS_ADDRESS:
										case SHORT_CIRCUIT_FUNCTION:
										
										case SLAVE_TEMPERATURE_COMMUNICATION_ERROR_HIGH:
										case SLAVE_TEMPERATURE_COMMUNICATION_ERROR_LOW:
										case SLEEP:
										case SOFT_SHUTDOWN:
							
										case SYSTEM_GR_OVER_TEMPERATURE_ALARM_TIMES:
										case SYSTEM_GR_OVER_TEMPERATURE_STOP_TIMES:
										
										case SYSTEM_RUN_MODE:
										case SYSTEM_SHORT_CIRCUIT_PROTECTION_TIMES:
										case SYSTEM_TIME_HIGH:
										case SYSTEM_TIME_LOW:
										case TESTING_IO:
										case TOTAL_CAPACITY_HIGH_BITS:
										case TOTAL_CAPACITY_LOW_BITS:
										case TOTAL_VOLTAGE_DIFFERENCE:
										case TRANSPARENT_MASTER:
										case UNDER_VOLTAGE_VALUE_WHEN_ALARM:
										case UNDER_VOLTAGE_VALUE_WHEN_STOPPED:
										case VOLTAGE_LOW_PROTECTION:
										
										case WORK_PARAMETER_CELL_AVERAGE_CHARGING:
										case WORK_PARAMETER_CELL_FLOAT_CHARGING:
										case WORK_PARAMETER_CELL_STOP_DISCHARGING:
										case WORK_PARAMETER_CURRENT_FIX_COEFFICIENT:
										case WORK_PARAMETER_CURRENT_FIX_OFFSET:
										case WORK_PARAMETER_PCS_MODBUS_ADDRESS:
										case WORK_PARAMETER_SET_CHARGER_OUTPUT_CURRENT:
										case WORK_PARAMETER_SYSTEM_CAPACITY:
										case WORK_PARAMETER_SYSTEM_RTC_TIME:
										case WORK_PARAMETER_SYSTEM_SOC:
										case WORK_PARAMETER_SYSTEM_SOH_DEFAULT_VALUE:
										case ALARM_FLAG_REGISTER_1:
										case ALARM_FLAG_REGISTER_2:
										case PROTECT_FLAG_REGISTER_1:
										case PROTECT_FLAG_REGISTER_2:
										case WORK_PARAMETER_SYSTEM_RTC_TIME_HIGH_BITS:
										case WORK_PARAMETER_SYSTEM_RTC_TIME_LOW_BITS:
										case STATE_MACHINE:
											return new IntegerReadChannel(s, channelId);
						// ===========================================
				
			
						
						
					}
					return null;
				}) //
		).flatMap(channel -> channel);
	}
}
