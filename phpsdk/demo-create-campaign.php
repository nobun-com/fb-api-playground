<?php
include 'vendor/autoload.php';
$APP_ID=file_get_contents('resources/app_id');
$APP_SECRET=file_get_contents('resources/app_secret');
$AD_ACCOUNT_ID=file_get_contents('resources/ad_account_id');
$ACCESS_TOKEN=file_get_contents('resources/access_token');

echo "app id:".$APP_ID;
echo "app secret:".$APP_SECRET;
echo "ad account id:".$AD_ACCOUNT_ID;
echo "access token:".$ACCESS_TOKEN;

use FacebookAds\Api;
$appsecret_proof = hash_hmac('sha256', $ACCESS_TOKEN, $APP_SECRET);
Api::init($APP_ID, $APP_SECRET, $appsecret_proof);

echo "Api init successfully";

use FacebookAds\Object\AdUser;
$user = (new AdUser('me'))->read(array('id'));
echo $user->id."\n";

use FacebookAds\Object\AdCampaign;
use FacebookAds\Object\Fields\AdCampaignFields;

$campaign = new AdCampaign(null, $AD_ACCOUNT_ID);
$campaign->setData(array(
	AdCampaignFields::NAME => 'Demo Campaign',
	AdCampaignFields::STATUS => AdCampaign::STATUS_PAUSED,
));

//$campaign->create();
//echo "Campaign ID:".$campaign->id."\n";
?>
